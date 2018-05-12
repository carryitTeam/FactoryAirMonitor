package com.carryit.base.fam.service;

import com.carryit.base.fam.bean.GroupInfo;
import com.carryit.base.fam.bean.User;
import com.carryit.base.fam.dao.GroupInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("groupInfoService")
public class GroupInfoService implements IGroupInfoService {

    @Autowired
    private GroupInfoDao groupInfoDao;

    @Override
    public int addGroupInfo(GroupInfo groupInfo) {
        return groupInfoDao.addGroupInfo(groupInfo);
    }

    @Override
    public int deleteGroupInfo(GroupInfo groupInfo) {
        return groupInfoDao.deleteGroupInfo(groupInfo);
    }

    @Override
    public int updateGroupInfo(GroupInfo groupInfo) {
        return groupInfoDao.updateGroupInfo(groupInfo);
    }

    @Override
    public GroupInfo queryGroupInfoById(GroupInfo groupInfo) {
        return groupInfoDao.queryGroupInfoById(groupInfo);
    }

    @Override
    public List<GroupInfo> queryAllGroupInfo() {
        return groupInfoDao.queryAllGroupInfo();
    }
}
