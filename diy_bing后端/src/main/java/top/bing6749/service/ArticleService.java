package top.bing6749.service;

import top.bing6749.domain.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import top.bing6749.domain.ArticleAndTag;
import top.bing6749.domain.Product;
import top.bing6749.entity.PageResult;
import top.bing6749.entity.QueryPageBean;

import java.text.ParseException;
import java.util.List;

/**
* @author MaRui
* @description 针对表【article】的数据库操作Service
* @createDate 2022-06-16 08:21:06
*/
public interface ArticleService extends IService<Article> {

    public List<ArticleAndTag> findArticles(int i) throws ParseException;

    public PageResult findAllArticle(QueryPageBean queryPageBean);

    public Boolean deleteArticleById(Integer id);

    public Article findArticleById(Integer id);

    public Boolean updateArticle(Article article);

    public Boolean addArticle(Article article);



    Boolean addView(int id);
}
