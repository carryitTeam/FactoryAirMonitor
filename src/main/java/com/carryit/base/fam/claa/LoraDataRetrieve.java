package com.carryit.base.fam.claa;

import com.carryit.base.fam.bean.LoraData;
import com.carryit.base.fam.connection.Connection;
import com.carryit.base.fam.utils.Base64Utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * Created by hlzou on 2018/1/31.
 */

@Component("loraDataRetrieve")
@Scope("prototype")
public class LoraDataRetrieve implements Runnable {

    private List<LoraData> loraDataCache = new LinkedList<>();

    private Connection connection;

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

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        ObjectMapper objectMapper = new ObjectMapper();
        int i = 0;
        Long start = System.currentTimeMillis();
        while (connection != null && isRunFlag()) {
            System.out.println("--------------" + i);
            try {
                Thread.sleep(100l);
                String originData = new String(connection.getData());
                String[] ds = originData.split("\n");
                System.out.println(ds.length);
                for (int j = 0; j < (ds.length + 1) / 3; j++) {
                    LoraData loraData = new LoraData();
                    loraData.setDataLen(Integer.parseInt(ds[j * 3 + 1]));
                    String allContent = ds[j * 3 + 2];
                    loraData.setContentJson(allContent);
                    Map<String,Object> dataMap = objectMapper.readValue(allContent, Map.class);
                    if (dataMap.containsKey("payload")){
                        String careData = Base64Utils.CharToHex(Base64Utils.base64Decode((String) dataMap.get("payload")));
                        loraData.setCareData(careData);
                        loraDataCache.add(loraData);
                        System.out.println(loraDataCache);
                    }
                }
                Long end = System.currentTimeMillis();

                //缓存中大于10或10s后写入db
                if (loraDataCache.size() > 10 || (loraDataCache.size() > 0 && (end - start) > 5000)) {
                    start = System.currentTimeMillis();
                    System.out.println("保存缓存loradata");
                    loraDataCache.clear();
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            } finally {
            }
            i++;
        }
        System.out.println("保存缓存loradata");
        loraDataCache.clear();
    }
}
