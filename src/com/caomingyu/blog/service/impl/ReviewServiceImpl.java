package com.caomingyu.blog.service.impl;

import com.caomingyu.blog.mapper.ReplyMapper;
import com.caomingyu.blog.mapper.ReviewMapper;
import com.caomingyu.blog.pojo.Review;
import com.caomingyu.blog.pojo.ReviewExample;
import com.caomingyu.blog.service.ReplyService;
import com.caomingyu.blog.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewMapper reviewMapper;
    @Autowired
    ReplyService replyService;
    @Override
    public void add(Review review) {
        reviewMapper.insert(review);
    }

    @Override
    public void delete(int id) {
        reviewMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Review review) {

    }

    @Override
    public List<Review> list(int aid) {
        ReviewExample example = new ReviewExample();
        example.createCriteria().andArticle_idEqualTo(aid);
        example.setOrderByClause("id desc");
        List<Review> rs = reviewMapper.selectByExample(example);
        for (Review r:rs
             ) {
            r.setReplies(replyService.list(r.getId()));
        }
        return rs;
    }

    @Override
    public Review get(int id) {
        return reviewMapper.selectByPrimaryKey(id);
    }
}
