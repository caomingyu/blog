package com.caomingyu.blog.service;

import com.caomingyu.blog.pojo.Review;

import java.util.List;

public interface ReviewService {
    void add(Review review);

    void delete(int id);

    void update(Review review);

    List<Review> list(int aid);

    Review get(int id);

    void updateByUid(int uid);

    List<Review> listByUid(int uid);
}
