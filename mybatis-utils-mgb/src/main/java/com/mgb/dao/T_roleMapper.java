package com.mgb.dao;

import com.mgb.model.T_role;

public interface T_roleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(T_role record);

    int insertSelective(T_role record);

    T_role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T_role record);

    int updateByPrimaryKey(T_role record);
}