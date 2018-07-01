package com.caomingyu.blog.mapper;

import com.caomingyu.blog.pojo.UserDetail;
import com.caomingyu.blog.pojo.UserDetailExample;
import java.util.List;

public interface UserDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserDetail record);

    int insertSelective(UserDetail record);

    List<UserDetail> selectByExample(UserDetailExample example);

    UserDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserDetail record);

    int updateByPrimaryKey(UserDetail record);
}