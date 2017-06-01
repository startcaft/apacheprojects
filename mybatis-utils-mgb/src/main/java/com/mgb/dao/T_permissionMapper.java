package com.mgb.dao;

import com.mgb.model.T_permission;

public interface T_permissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(T_permission record);

    int insertSelective(T_permission record);

    T_permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T_permission record);

    int updateByPrimaryKey(T_permission record);
}