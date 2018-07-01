package com.caomingyu.blog.mapper;

import com.caomingyu.blog.pojo.Like;
import com.caomingyu.blog.pojo.LikeExample;
import java.util.List;

public interface LikeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Like record);

    int insertSelective(Like record);

    List<Like> selectByExample(LikeExample example);

    Like selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Like record);

    int updateByPrimaryKey(Like record);
}