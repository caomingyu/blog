package com.caomingyu.blog.controller;

import com.caomingyu.blog.pojo.Article;
import com.caomingyu.blog.pojo.Category;
import com.caomingyu.blog.pojo.Review;
import com.caomingyu.blog.pojo.User;
import com.caomingyu.blog.service.ArticleService;
import com.caomingyu.blog.service.CategoryService;
import com.caomingyu.blog.service.ReviewService;
import com.caomingyu.blog.service.UserService;
import com.caomingyu.blog.util.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class ReviewController {
    @Autowired
    ReviewService reviewService;
    @Autowired
    ArticleService articleService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    UserService userService;
    @RequestMapping("admin_review_list")
    public String list(Model model, Page page, int aid) {
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Review> rs = reviewService.list(aid);
        Article a = articleService.get(aid);
        Category c = categoryService.get(a.getCategory_id());
        int total = (int) new PageInfo<>(rs).getTotal();
        page.setTotal(total);
        page.setParams("&aid=" + aid);
        User u = userService.get(a.getUid());
        model.addAttribute("rs", rs);
        model.addAttribute("page", page);
        model.addAttribute("c", c);
        model.addAttribute("a", a);
        model.addAttribute("u", u);
        return "listReview";
    }
    @RequestMapping("admin_review_context")
    public String show(Model model,int rid){
        Review r = reviewService.get(rid);
        Article a = articleService.get(r.getArticle_id());
        Category c = categoryService.get(a.getCategory_id());
        model.addAttribute("r", r);
        model.addAttribute("a", a);
        model.addAttribute("c", c);
        return "showContext";
    }
}
