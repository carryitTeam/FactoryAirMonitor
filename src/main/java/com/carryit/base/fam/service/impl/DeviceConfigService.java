package com.carryit.base.fam.service.impl;

import com.carryit.base.fam.bean.DeviceConfig;
import com.carryit.base.fam.dao.DeviceConfigDao;
import com.carryit.base.fam.service.IDeviceConfigService;
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
    public int deleteDeviceConfigByGroupId(DeviceConfig deviceConfig) {
        return deviceConfigDao.deleteDeviceConfigByGroupId(deviceConfig);
    }

    @Override
    public int deleteDeviceConfigByParentId(DeviceConfig deviceConfig) {
        return deviceConfigDao.deleteDeviceConfigByParentId(deviceConfig);
    }

    @Override
    public int updateDeviceConfigById(DeviceConfig deviceConfig) {
        return deviceConfigDao.updateDeviceConfigById(deviceConfig);
    }

    @Override
    public int updateDeviceXYById(DeviceConfig deviceConfig) {
        return deviceConfigDao.updateDeviceXYById(deviceConfig);
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

    @Override
    public List<DeviceConfig> querySensorConfigByDeviceAppEui(DeviceConfig deviceConfig) {
        return deviceConfigDao.querySensorConfigByDeviceAppEui(deviceConfig);
    }

    @Override
    public List<DeviceConfig> queryDeviceConfigByAppEui(DeviceConfig deviceConfig) {
        return deviceConfigDao.queryDeviceConfigByAppEui(deviceConfig);
    }
}
