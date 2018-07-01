package com.caomingyu.blog.service.impl;

import com.caomingyu.blog.mapper.CategoryMapper;
import com.caomingyu.blog.pojo.Category;
import com.caomingyu.blog.pojo.CategoryExample;
import com.caomingyu.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public void add(Category category) {
        categoryMapper.insert(category);
    }

    @Override
    public void delete(int cid) {
        categoryMapper.deleteByPrimaryKey(cid);
    }

    @Override
    public void update(Category category) {
        categoryMapper.updateByPrimaryKey(category);
    }

    @Override
    public List<Category> list() {
        CategoryExample example = new CategoryExample();
        example.setOrderByClause("id");
        List<Category> cs = categoryMapper.selectByExample(example);
        return cs;
    }

    @Override
    public Category get(int cid) {
        Category category = categoryMapper.selectByPrimaryKey(cid);
        return category;
    }
}
