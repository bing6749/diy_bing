package top.bing6749.controller;
/*
 * @author  MaRui
 * @date  2022/6/16 8:23
 * @version 1.0
 */


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.bing6749.domain.Article;
import top.bing6749.domain.ArticleAndTag;
import top.bing6749.domain.Product;
import top.bing6749.entity.MessageConstant;

import top.bing6749.entity.PageResult;
import top.bing6749.entity.QueryPageBean;
import top.bing6749.entity.Result;
import top.bing6749.service.ArticleService;

import java.util.List;

/**
 * @author MaRui
 */
@RestController
@RequestMapping("/article")
//@JsonIgnoreProperties(value = { “handler” })
public class ArticleController {
    @Autowired
    public ArticleService articleService;

//    根据文章type查找对应的文章合集用于列表展示
    @RequestMapping("/findArticles")
    public Result findArticles(int type){
        try {
            List<ArticleAndTag> list = articleService.findArticles(type);
            return new Result(true, MessageConstant.QUERY_ARTICLEINFORMATION_SUCCESS,list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_ARTICLEINFORMATION_FAIT);

        }
    }
    //    查找所有文章列表
    @PostMapping(value = "/findAllArticle")
    public PageResult findAllArticle(@RequestBody QueryPageBean queryPageBean) {

        PageResult list = articleService.findAllArticle(queryPageBean);
        return list;
    }
    //删除单个文章通过ID
    @GetMapping("/deleteArticleById")
    public Result deleteArticleById(@Param("id") Integer id) {
        Boolean flag = articleService.deleteArticleById(id);
        try {
            if (flag) {
                return new Result(flag, MessageConstant.DELETE_ARTICLE_SUCCESS,flag);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(flag, MessageConstant.DELETE_ARTICLE_FAIT,flag);
    }
    //通过ID查找单个文章
    @GetMapping("/findArticleById")
    public Result findArticleById(@Param("id") Integer id) {
        try {
            Article article = articleService.findArticleById(id);
            return new Result(true,MessageConstant.QUERY_ARTICLE_SUCCESS,article);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false,MessageConstant.QUERY_ARTICLE_FAIT);
    }
    //修改文章
    @PostMapping("/editArticle")
    public Result editArticle(@RequestBody Article article){
        Boolean flag = false;
        try {
            flag = articleService.updateArticle(article);
            if (flag = true){
                return new Result(flag,MessageConstant.EDIT_ARTICLE_SUCCESS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(flag,MessageConstant.EDIT_ARTICLE_FAIT);

    }
    //添加文章
    @PostMapping("/addArticle")
    public Result addArticle(@RequestBody Article article){
        Boolean flag = false;
        try {
            flag = articleService.addArticle(article);
            if (flag = true){
                return new Result(flag,MessageConstant.ADD_ARTICLE_SUCCESS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(flag,MessageConstant.ADD_ARTICLE_FAIT);

    }
    //浏览文章
    @PutMapping("/addView")
    public Result addView(@RequestParam("articleId") int articleId){
        Boolean flag = articleService.addView(articleId);
        try {
            return new Result(flag,MessageConstant.ADDVIEW_ARTICLE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(flag,MessageConstant.ADDVIEW_ARTICLE_FAIT);
    }
}
