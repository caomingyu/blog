package com.caomingyu.blog.service;

import com.caomingyu.blog.pojo.Article;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ArticleService {
    void add(Article article);

    void delete(int id,HttpSession session);

    void update(Article article);

    Article get(int id);

    List<Article> list(int cid);
}
