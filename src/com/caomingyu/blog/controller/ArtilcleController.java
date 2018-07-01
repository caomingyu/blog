package com.caomingyu.blog.controller;

import com.caomingyu.blog.pojo.Article;
import com.caomingyu.blog.pojo.Category;
import com.caomingyu.blog.service.ArticleService;
import com.caomingyu.blog.service.CategoryService;
import com.caomingyu.blog.service.UserService;
import com.caomingyu.blog.util.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("")
public class ArtilcleController {
    @Autowired
    ArticleService articleService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    UserService userService;
    @RequestMapping("admin_article_list")
    public String list(Model model, Page page, int cid) {
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Article> as =articleService.list(cid);
        Category category = categoryService.get(cid);
        for (Article a:as
             ) {
            a.setCategory(category);
        }
        int total = (int) new PageInfo<>(as).getTotal();
        page.setTotal(total);
        page.setParams("&cid="+cid);
        model.addAttribute("as", as);
        model.addAttribute("page", page);
        model.addAttribute("c", category);
        return "listArticle";
    }
    @RequestMapping("admin_article_context")
    public String show(Model model,int aid){
        Article a = articleService.get(aid);
        a.setUser(userService.get(a.getUid()));
        a.setCategory(categoryService.get(a.getCategory_id()));
        Category c = categoryService.get(a.getCategory_id());
        model.addAttribute("a", a);
        model.addAttribute("c", c);
        return "showContext";
    }
    @RequestMapping("admin_article_add")
    public String add(Model model, int cid){
        Category c = categoryService.get(cid);
        model.addAttribute("c", c);
        return "addArticle";
    }
    @RequestMapping("admin_article_add_")
    public String add_(Article article){
        article.setCreatedate(new Date());
        articleService.add(article);
        return "redirect:admin_article_list?cid="+article.getCategory_id();
    }
    @RequestMapping("admin_article_delete")
    public String delete(int aid, HttpSession session){
        Article a = articleService.get(aid);
        articleService.delete(aid,session);
        return "redirect:admin_article_list?cid="+a.getCategory_id();
    }

    @RequestMapping("admin_article_edit")
    public String edit(Model model,int aid) {
        Article a = articleService.get(aid);
        Category c = categoryService.get(a.getCategory_id());
        System.out.println(a.getCreatedate());
        model.addAttribute("a", a);
        model.addAttribute("c", c);
        return "editArticle";
    }
    @RequestMapping("admin_article_update")
    public String update(Article a){
        articleService.update(a);
        return "redirect:admin_article_list?cid="+a.getCategory_id();
    }
}
