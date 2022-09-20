package top.bing6749.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import top.bing6749.domain.Article;
import top.bing6749.domain.ArticleAndTag;
import top.bing6749.domain.Product;
import top.bing6749.entity.PageResult;
import top.bing6749.entity.QueryPageBean;
import top.bing6749.service.ArticleService;
import top.bing6749.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
* @author MaRui
* @description 针对表【article】的数据库操作Service实现
* @createDate 2022-06-16 08:21:06
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
    implements ArticleService{
    @Autowired
    public ArticleMapper articleMapper;

    //    根据文章type查找对应的文章合集用于列表展示
    @Override
    public List<ArticleAndTag> findArticles(int i) throws ParseException {
        List<ArticleAndTag> articleAndTags = articleMapper.selectByType(i);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        for (ArticleAndTag articleAndTag : articleAndTags) {
//            Date articleDate = articleAndTag.getArticleDate();
//            String format = sdf.format(articleDate);
//            articleDate.setTime(Long.parseLong(format));
//        }
        return articleAndTags;
    }

    @Override
    public PageResult findAllArticle(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();
        System.out.println(queryPageBean);
        IPage<Article> page = new Page<>(currentPage, pageSize);
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        if (queryString.length() != 0){
            queryWrapper.like("article_title",queryString);
        }
        queryWrapper.select("article_title", "article_id");
        IPage<Article> articlePage = articleMapper.selectPage(page, queryWrapper);
        long total = articlePage.getTotal();
        List<Article> records = articlePage.getRecords();
//        List<ArticleAndTag> articleAndTags = articleMapper.selectByArticleTitle(queryString,page);

        return new PageResult(total,records);
    }

    @Override
    public Boolean deleteArticleById(Integer id) {
        int i = articleMapper.deleteById(id);
        if (i == 1){
            return true;
        }
        return false;
    }

    @Override
    public Article findArticleById(Integer id) {
        Article article = articleMapper.selectById(id);
        return article;
    }

    @Override
    public Boolean updateArticle(Article article) {
        int update = articleMapper.updateById(article);
        if (update == 1){
            return true;
        }
        return false;
    }

    @Override
    public Boolean addArticle(Article article) {
        int insert = articleMapper.insert(article);
        if (insert == 1){
            return true;
        }
        return false;
    }

    @Override
    public Boolean addView(int id) {
        int i = articleMapper.addViewByArticleId(id);
        if (i == 1){
            return true;
        }
        return false;
    }

}




