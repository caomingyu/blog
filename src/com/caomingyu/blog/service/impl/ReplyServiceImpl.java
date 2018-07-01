package com.caomingyu.blog.service.impl;

import com.caomingyu.blog.mapper.ReplyMapper;
import com.caomingyu.blog.pojo.Reply;
import com.caomingyu.blog.pojo.ReplyExample;
import com.caomingyu.blog.service.ReplyService;
import com.caomingyu.blog.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    ReplyMapper replyMapper;
    @Override
    public void add(Reply reply) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Reply reply) {

    }

    @Override
    public List<Reply> list(int rid) {
        ReplyExample example = new ReplyExample();
        example.createCriteria().andReview_idEqualTo(rid);
        example.setOrderByClause("id desc");
        List<Reply>rs= replyMapper.selectByExample(example);
        return rs;
    }

    @Override
    public Reply get(int id) {
        return null;
    }
}
