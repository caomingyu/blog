package com.caomingyu.blog.mapper;

import com.caomingyu.blog.pojo.UserRole;
import com.caomingyu.blog.pojo.UserRoleExample;
import java.util.List;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    List<UserRole> selectByExample(UserRoleExample example);

    UserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    void deleteByUid(int uid);

    List<UserRole> getByRid(int rid);

    void deleteByRid(int rid);
}