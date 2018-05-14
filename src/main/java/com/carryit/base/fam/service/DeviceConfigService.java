package com.carryit.base.fam.service;

import com.carryit.base.fam.bean.DeviceConfig;
import com.carryit.base.fam.dao.DeviceConfigDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceConfigService implements IDeviceConfigService {

    @Autowired
    private DeviceConfigDao deviceConfigDao;

    @Override
    public int addDeviceConfig(DeviceConfig deviceConfig) {
        return deviceConfigDao.addDeviceConfig(deviceConfig);
    }

    @Override
    public int deleteDeviceConfigById(DeviceConfig deviceConfig) {
        return deviceConfigDao.deleteDeviceConfigById(deviceConfig);
    }

    @Override
    public int updateDeviceConfigById(DeviceConfig deviceConfig) {
        return deviceConfigDao.updateDeviceConfigById(deviceConfig);
    }

    @Override
    public List<DeviceConfig> queryDeviceConfigByGroupId(DeviceConfig deviceConfig) {
        return deviceConfigDao.queryDeviceConfigByGroupId(deviceConfig);
    }

    @Override
    public List<DeviceConfig> queryAllDeviceConfig() {
        return deviceConfigDao.queryAllDeviceConfig();
    }

    @Override
    public List<DeviceConfig> queryDeviceConfigByType(DeviceConfig deviceConfig) {
        return deviceConfigDao.queryDeviceConfigByType(deviceConfig);
    }

    @Override
    public int updateSensorConfigById(DeviceConfig deviceConfig) {
        return deviceConfigDao.updateSensorConfigById(deviceConfig);
    }

    @Override
    public int addSensorConfig(DeviceConfig deviceConfig) {
        return deviceConfigDao.addSensorConfig(deviceConfig);
    }

    @Override
    public List<DeviceConfig> queryDeviceConfigByParentId(DeviceConfig deviceConfig) {
        return deviceConfigDao.queryDeviceConfigByParentId(deviceConfig);
    }
}
