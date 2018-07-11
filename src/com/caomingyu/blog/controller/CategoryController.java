package com.caomingyu.blog.controller;

import com.caomingyu.blog.pojo.Article;
import com.caomingyu.blog.pojo.Category;
import com.caomingyu.blog.service.ArticleService;
import com.caomingyu.blog.service.CategoryService;
import com.caomingyu.blog.util.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ArticleService articleService;
    @RequestMapping("admin_category_list")
    public String list(Model model, Page page){
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Category> cs = categoryService.list();
        int total = (int) new PageInfo<>(cs).getTotal();
        page.setTotal(total);
        for (Category c:cs
             ) {
            c.setArticles(articleService.list(c.getId()));
        }
        model.addAttribute("cs", cs);
        model.addAttribute("page", page);
        return "listCategory";
    }
    @RequestMapping("admin_category_add")
    public String add(Category category){
        categoryService.add(category);
        return "redirect:admin_category_list";
    }
    @RequestMapping("admin_category_delete")
    public String delete(int cid){
        categoryService.delete(cid);
        return "redirect:admin_category_list";
    }
    @RequestMapping("admin_category_edit")
    public String edit(Model model,int cid){
        Category c = categoryService.get(cid);
        model.addAttribute("c", c);
        return "editCategory";
    }
    @RequestMapping("admin_category_update")
    public String update(Category category){
        categoryService.update(category);
        return "redirect:admin_category_list";
    }
    @RequestMapping("admin_category_checkDelete")
    @ResponseBody
    public String check(String cid){
        List<Article> as = articleService.list(Integer.valueOf(cid));
        if (as.size()==0) return "success";
        return "unsuccess";
    }
}
