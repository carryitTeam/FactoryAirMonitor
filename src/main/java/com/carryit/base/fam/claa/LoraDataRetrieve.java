package com.carryit.base.fam.claa;

import com.carryit.base.fam.bean.LoraData;
import com.carryit.base.fam.connection.Connection;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;


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
        int i = 0;
        Long start = System.currentTimeMillis();
        while (connection != null && isRunFlag()) {
            System.out.println("--------------" + i);
            try {
                Thread.sleep(100l);
                String originData = new String(connection.getData()).trim();
                String [] ds = originData.split("\n");
                System.out.println(ds.length);
                for (int j=0;j< (ds.length+1)/3; j++){
                    LoraData loraData = new LoraData();
                    loraData.setDataLen(Integer.parseInt(ds[j*3]));
                    loraData.setContentJson(ds[j*3+1]);
                    System.out.println(loraData);
                    loraDataCache.add(loraData);
                }
                Long end = System.currentTimeMillis();

                //缓存中大于10或10s后写入db
                if (loraDataCache.size()>10|| (loraDataCache.size()>0 && (end-start)>5000)){
                    start = System.currentTimeMillis();
                    System.out.println("保存缓存loradata");
                    loraDataCache.clear();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }
            i++;
        }
        System.out.println("保存缓存loradata");
        loraDataCache.clear();
    }
}
