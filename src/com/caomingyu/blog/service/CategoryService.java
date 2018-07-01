package com.caomingyu.blog.service;

import com.caomingyu.blog.pojo.Category;

import java.util.List;

public interface CategoryService {
    void add(Category category);

    void delete(int cid);

    void update(Category category);

    List<Category> list();

    Category get(int cid);
}
