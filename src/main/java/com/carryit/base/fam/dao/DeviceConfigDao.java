package com.carryit.base.fam.dao;

import com.carryit.base.fam.bean.DeviceConfig;
import com.carryit.base.fam.bean.LogOps;

import java.util.List;

/**
 * Created by hlzou on 2018/2/27.
 */
public interface DeviceConfigDao {

    int updateSensorConfigById(DeviceConfig deviceConfig);

    int addSensorConfig(DeviceConfig deviceConfig);

    int addDeviceConfig(DeviceConfig deviceConfig);

    int deleteDeviceConfigById(DeviceConfig deviceConfig);

    int updateDeviceConfigById(DeviceConfig deviceConfig);

    List<DeviceConfig> queryDeviceConfigByGroupId(DeviceConfig deviceConfig);

    List<DeviceConfig> queryAllDeviceConfig();

    List<DeviceConfig> queryDeviceConfigByType(DeviceConfig deviceConfig);
}
