package top.bing6749.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.bing6749.domain.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.bing6749.domain.ArticleAndTag;

import java.util.List;

/**
* @author MaRui
* @description 针对表【article】的数据库操作Mapper
* @createDate 2022-06-16 08:21:06
* @Entity top.bing6749.domain.Article
*/
@Mapper
@Repository
public interface ArticleMapper extends BaseMapper<Article> {

//    根据文章type查询文章列表
    @Select("select * from article where article_type = #{value}")
    @Results({
            @Result(id = true,column = "article_id",property = "articleId"),
            @Result(column = "article_title",property = "articleTitle"),
            @Result(column = "article_type",property = "articleType"),
            @Result(column = "article_date",property = "articleDate"),
            @Result(column = "article_description",property = "articleDescription"),
            @Result(column = "article_content",property = "articleContent"),
            @Result(column = "article_image",property = "articleImage"),
            @Result(column = "article_view",property = "articleView"),
            @Result(column = "article_id",property = "tags",javaType = List.class,
                    many = @Many(select = "top.bing6749.mapper.ArticleTagMapper.findTagNamesByAid"))
    })
    List<ArticleAndTag> selectByType(int i);


    //    查询所有文章列表
    @Select("select * from article")
    @Results({
            @Result(id = true,column = "article_id",property = "articleId"),
            @Result(column = "article_title",property = "articleTitle"),
            @Result(column = "article_type",property = "articleType"),
            @Result(column = "article_date",property = "articleDate"),
            @Result(column = "article_description",property = "articleDescription"),
            @Result(column = "article_content",property = "articleContent"),
            @Result(column = "article_image",property = "articleImage"),
            @Result(column = "article_view",property = "articleView"),
            @Result(column = "article_id",property = "tags",javaType = List.class,
                    many = @Many(select = "top.bing6749.mapper.ArticleTagMapper.findTagNamesByAid"))
    })
    List<ArticleAndTag> findAllArticle();


    List<ArticleAndTag> selectByArticleTitle(@Param("queryString") String queryString,@Param("page") Page<ArticleAndTag> page);

    int addViewByArticleId(int id);
}




