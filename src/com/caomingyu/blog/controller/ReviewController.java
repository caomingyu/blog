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
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
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
        for (Review r:rs
             ) {
            User u = new User();
            if (r.getUid()==null){
                u.setName("佚名");
            }else {
                u = userService.get(r.getUid());
            }
            r.setUser(u);
        }
        User u = new User();
        if (a.getUid()==null){
            u.setName("佚名");
        }else {
            u = userService.get(a.getUid());
        }

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
    @RequestMapping("admin_review_add")
    public String add(int article_id,Review review){
        Article a = articleService.get(article_id);
        Subject subject = SecurityUtils.getSubject();
        String name = subject.getPrincipal().toString();
        User u = userService.get(name);
        review.setUid(u.getId());
//        if (a.getUid()==null){
//            review.setUid(null);
//        }else {
//            review.setUid(a.getUid());
//        }
        review.setCreatedate(new Date());
        reviewService.add(review);
        return "redirect:admin_review_list?aid="+article_id;
    }
    @RequestMapping("admin_review_delete")
    public String delete(int rid){
        Review r = reviewService.get(rid);
        reviewService.delete(rid);
        return "redirect:admin_review_list?aid="+r.getArticle_id();
    }
    @RequestMapping("admin_review_edit")
    public String edit(int rid,Model model){
        Review r = reviewService.get(rid);
        model.addAttribute("r", r);
        return "editReview";
    }
    @RequestMapping("admin_review_update")
    public String update(int id,String context_){
        Review review = reviewService.get(id);
        if (!context_.equals("")){
            review.setContext_(context_);
            review.setCreatedate(new Date());
        }
        reviewService.update(review);
        return "redirect:admin_review_list?aid="+review.getArticle_id();
    }
}
