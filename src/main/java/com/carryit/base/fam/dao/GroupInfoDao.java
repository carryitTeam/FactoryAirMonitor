package com.carryit.base.fam.dao;

import com.carryit.base.fam.bean.GroupInfo;
import com.carryit.base.fam.bean.User;

import java.util.List;

/**
 * Created by hlzou on 2018/2/27.
 */
public interface GroupInfoDao {

    int addGroupInfo(GroupInfo groupInfo);

    int deleteGroupInfo(GroupInfo groupInfo);

    int updateGroupInfo(GroupInfo groupInfo);

    GroupInfo queryGroupInfoById(GroupInfo groupInfo);

    List<GroupInfo> queryAllGroupInfo();

}
