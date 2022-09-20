package top.bing6749.mapper;

import top.bing6749.domain.ArticleTag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.bing6749.domain.Tag;

import java.util.List;

/**
* @author MaRui
* @description 针对表【article_tag】的数据库操作Mapper
* @createDate 2022-06-13 16:15:48
* @Entity top.bing6749.domain.ArticleTag
*/
public interface ArticleTagMapper extends BaseMapper<ArticleTag> {
//    根据文章id查询对应的文章tag名列表
    List<Tag> findTagNamesByAid(int aid);

}




