package com.caomingyu.blog.mapper;

import com.caomingyu.blog.pojo.RolePermission;
import com.caomingyu.blog.pojo.RolePermissionExample;
import java.util.List;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    List<RolePermission> selectByExample(RolePermissionExample example);

    RolePermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);

    void delete(int rid);

    void deleteByPid(int pid);
}