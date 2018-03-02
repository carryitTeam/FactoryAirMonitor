package com.carryit.base.fam.claa;

import com.carryit.base.fam.bean.Datas;
import com.carryit.base.fam.bean.LoraData;
import com.carryit.base.fam.connection.CSJoinReq;
import com.carryit.base.fam.connection.Configure;
import com.carryit.base.fam.connection.Connection;
import com.carryit.base.fam.connection.TCPConnection;
import com.carryit.base.fam.service.DatasService;
import com.carryit.base.fam.utils.Base64Utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.SocketException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.carryit.base.fam.utils.CmdMessageUtils.composeMessage;
import static com.carryit.base.fam.utils.CmdMessageUtils.encapsulateContent;


/**
 * Created by hlzou on 2018/1/31.
 */

@Component("loraDataRetrieve")
@Scope("prototype")
public class LoraDataRetrieve implements Runnable {

    private List<Datas> loraDataCache = new LinkedList<>();

    @Autowired
    private DatasService datasService;

    @Autowired
    private TCPConnection connection;

    private boolean isAccept = false;

    public boolean isAccept() {
        return isAccept;
    }

    public void setAccept(boolean accept) {
        isAccept = accept;
    }

    private String host;

    private int port;

    private String appEui;

    public String getAppEui() {
        return appEui;
    }

    public void setAppEui(String appEui) {
        this.appEui = appEui;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    private boolean runFlag = true;

    public boolean isRunFlag() {
        return runFlag;
    }

    public void setRunFlag(boolean runFlag) {
        this.runFlag = runFlag;
    }

    public Connection getConnection() {
        return connection;
    }

    public void initConnection() {
//        this.connection = new TCPConnection();
        try {
            connection.getConnection(host, port);
            CSJoinReq jq = new CSJoinReq();
            jq.setAppEUI(appEui);
            jq.setAppNonce(Integer.parseInt("12345678"));
            jq.setChallenge("12345678");
            jq.setCmdSeq(Configure.cmdseq_counter);
            jq.setCMD("JOIN");
            String body = encapsulateContent(jq);
            System.out.println(body);
            jq.setHeader(Integer.toString(body.length()));
            jq.setContent(body);
            byte[] message = composeMessage(body);
            connection.putData(message);
            System.out.println("join");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        ObjectMapper objectMapper = new ObjectMapper();
        int i = 0;
        Long start = System.currentTimeMillis();
        StringBuffer dataCheck = new StringBuffer();
        while (isRunFlag()) {
            if (connection == null || connection.isClosed()) {
                initConnection();
                System.out.println("--------------reset connection-----------------");
            }
            System.out.println("--------------" + i);
            try {
                Thread.sleep(100l);
                String originData = new String(connection.getData());
                if (i == 0 && originData.contains("JOIN ACCEPT")) {
                    isAccept = true;
                }
                //处理发送过来数据断了的情况
                if (!originData.trim().endsWith("}")) {
                    dataCheck.append(originData);
                    continue;
                } else {
                    dataCheck.append(originData);
                }
                String[] ds = dataCheck.toString().split("\n");
                dataCheck.delete(0, dataCheck.length());
                for (int j = 0; j < (ds.length + 1) / 3; j++) {
                    Datas datas = new Datas();
//                    loraData.setDataLen(Integer.parseInt(ds[j * 3 + 1]));
                    String allContent = ds[j * 3 + 2];
                    datas.setJsonData(allContent);
                    Map<String, Object> dataMap = objectMapper.readValue(allContent, Map.class);
                    if (dataMap.containsKey("payload")) {
                        String careData = Base64Utils.CharToHex(Base64Utils.base64Decode((String) dataMap.get("payload")));
                        datas.setRealData(careData);
                        datas.setAppEui((String) dataMap.get("AppEUI"));
                        datas.setDevEui((String) dataMap.get("DevEUI"));
                        loraDataCache.add(datas);
                    }
                }
                Long end = System.currentTimeMillis();

                //缓存中大于10或10s后写入db
                if (loraDataCache.size() > 10 || (loraDataCache.size() > 0 && (end - start) > 5000)) {
                    start = System.currentTimeMillis();
                    System.out.println(loraDataCache);
                    for (Datas d : loraDataCache) {
                        datasService.addDatas(d);
                    }
                    System.out.println("保存缓存loradata");
                    loraDataCache.clear();
                }
            } catch (SocketException e) {
                try {
                    if (isRunFlag()){
                        initConnection();
                        System.out.println("--------------reset SocketException-----------------");
                        System.out.println(connection.isClosed() + "_" + connection.isConnected());
                    }else {
                        System.out.println("--------------quit cmd-----------------");
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                connection.isClosed();
            }
            i++;
        }
        System.out.println("保存缓存loradata");
        loraDataCache.clear();
        connection.isClosed();
    }
}
