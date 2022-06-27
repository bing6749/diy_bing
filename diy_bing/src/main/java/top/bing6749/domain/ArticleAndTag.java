package top.bing6749.domain;
/*
 * @author  MaRui
 * @date  2022/6/16 9:28
 * @version 1.0
 */


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author MaRui
 */

//文章列表实体类
public class ArticleAndTag  implements Serializable {

    @Override
    public String toString() {
        return "ArticleAndTag{" +
                "articleId=" + articleId +
                ", articleType='" + articleType + '\'' +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleDate=" + articleDate +
                ", articleDescription='" + articleDescription + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleImage='" + articleImage + '\'' +
                ", articleView=" + articleView +
                ", articleStatus=" + articleStatus +
                ", tags=" + tags +
                '}';
    }

    private Integer articleId;


    private String articleType;


    private String articleTitle;


    private Date articleDate;


    private String articleDescription;


    private String articleContent;


    private String articleImage;


    private Integer articleView;


    private Integer articleStatus;

    private List<Tag> tags;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public Date getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(Date articleDate) {
        this.articleDate = articleDate;
    }

    public String getArticleDescription() {
        return articleDescription;
    }

    public void setArticleDescription(String articleDescription) {
        this.articleDescription = articleDescription;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleImage() {
        return articleImage;
    }

    public void setArticleImage(String articleImage) {
        this.articleImage = articleImage;
    }

    public Integer getArticleView() {
        return articleView;
    }

    public void setArticleView(Integer articleView) {
        this.articleView = articleView;
    }

    public Integer getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(Integer articleStatus) {
        this.articleStatus = articleStatus;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
