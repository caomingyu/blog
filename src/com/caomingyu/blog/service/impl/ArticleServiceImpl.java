package com.caomingyu.blog.service.impl;

import com.caomingyu.blog.mapper.ArticleMapper;
import com.caomingyu.blog.pojo.Article;
import com.caomingyu.blog.pojo.ArticleExample;
import com.caomingyu.blog.service.ArticleService;
import com.caomingyu.blog.service.UserService;
import com.caomingyu.blog.util.GetImageSrc;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    UserService userService;

    @Override
    public void add(Article article) {
        articleMapper.insert(article);
    }

    @Override
    public void delete(int id, HttpSession session) {
        Article a = articleMapper.selectByPrimaryKey(id);
        String html = a.getContext_();
        List<String> imgs = GetImageSrc.getImageSrc(html);
        List<String> ss = new ArrayList<>();
        if (null != imgs&&0!=imgs.size()) {
            for (String s : imgs
                    ) {
                ss.add(s.substring(21, s.length()));
            }
            System.out.println(session.getServletContext().getRealPath("/"));
            for (String s : ss
                    ) {
                File file = new File(session.getServletContext().getRealPath("") + s);
                if (file.exists()) {
                    System.out.println("文件***************************************");
                    file.delete();
                }
            }
        }

        articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Article article) {
        articleMapper.updateByPrimaryKeySelective(article);
    }

    @Override
    public Article get(int id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Article> list(int cid) {
        ArticleExample example = new ArticleExample();
        example.createCriteria().andCategory_idEqualTo(cid);
        example.setOrderByClause("id desc");
        List<Article> articles = articleMapper.selectByExample(example);
        for (Article a : articles
                ) {
            a.setUser(userService.get(a.getUid()));
        }
        return articles;
    }
}
