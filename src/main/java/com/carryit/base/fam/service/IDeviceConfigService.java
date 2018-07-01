package com.carryit.base.fam.service;

import com.carryit.base.fam.bean.DeviceConfig;

import java.util.List;

/**
 * Created by hlzou on 2018/2/27.
 */
public interface IDeviceConfigService {

    int addDeviceConfig(DeviceConfig deviceConfig);

    int deleteDeviceConfigById(DeviceConfig deviceConfig);

    int deleteDeviceConfigByGroupId(DeviceConfig deviceConfig);

    int deleteDeviceConfigByParentId(DeviceConfig deviceConfig);

    int updateDeviceConfigById(DeviceConfig deviceConfig);

    int updateDeviceXYById(DeviceConfig deviceConfig);

    List<DeviceConfig> queryDeviceConfigByGroupId(DeviceConfig deviceConfig);

    List<DeviceConfig> queryAllDeviceConfig();

    List<DeviceConfig> queryDeviceConfigByType(DeviceConfig deviceConfig);

    int updateSensorConfigById(DeviceConfig deviceConfig);

    int addSensorConfig(DeviceConfig deviceConfig);

    List<DeviceConfig>  queryDeviceConfigByParentId(DeviceConfig deviceConfig);

    List<DeviceConfig> querySensorConfigByDeviceAppEui(DeviceConfig deviceConfig);

    List<DeviceConfig> queryDeviceConfigByAppEui(DeviceConfig deviceConfig);

}
