package top.bing6749.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 
 * @TableName article
 */
@TableName(value ="article")
@Data
public class Article implements Serializable {
    /**
     * 
     */
    @TableId(value = "article_id",type = IdType.AUTO)
    private Integer articleId;

    /**
     * 
     */
    @TableField(value = "article_type")
    private String articleType;

    /**
     * 
     */
    @TableField(value = "article_title")
    private String articleTitle;

    /**
     * 
     */
    @TableField(value = "article_date")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date articleDate;

    /**
     * 
     */
    @TableField(value = "article_description")
    private String articleDescription;

    /**
     * 
     */
    @TableField(value = "article_content")
    private String articleContent;

    /**
     * 
     */
    @TableField(value = "article_image")
    private String articleImage;

    /**
     * 
     */
    @TableField(value = "article_view")
    private Integer articleView;

    /**
     * 0为文章存在状态 1为文章注销状态
     */
    @TableField(value = "article_status")
    private Integer articleStatus;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Article other = (Article) that;
        return (this.getArticleId() == null ? other.getArticleId() == null : this.getArticleId().equals(other.getArticleId()))
            && (this.getArticleType() == null ? other.getArticleType() == null : this.getArticleType().equals(other.getArticleType()))
            && (this.getArticleTitle() == null ? other.getArticleTitle() == null : this.getArticleTitle().equals(other.getArticleTitle()))
            && (this.getArticleDate() == null ? other.getArticleDate() == null : this.getArticleDate().equals(other.getArticleDate()))
            && (this.getArticleDescription() == null ? other.getArticleDescription() == null : this.getArticleDescription().equals(other.getArticleDescription()))
            && (this.getArticleContent() == null ? other.getArticleContent() == null : this.getArticleContent().equals(other.getArticleContent()))
            && (this.getArticleImage() == null ? other.getArticleImage() == null : this.getArticleImage().equals(other.getArticleImage()))
            && (this.getArticleView() == null ? other.getArticleView() == null : this.getArticleView().equals(other.getArticleView()))
            && (this.getArticleStatus() == null ? other.getArticleStatus() == null : this.getArticleStatus().equals(other.getArticleStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getArticleId() == null) ? 0 : getArticleId().hashCode());
        result = prime * result + ((getArticleType() == null) ? 0 : getArticleType().hashCode());
        result = prime * result + ((getArticleTitle() == null) ? 0 : getArticleTitle().hashCode());
        result = prime * result + ((getArticleDate() == null) ? 0 : getArticleDate().hashCode());
        result = prime * result + ((getArticleDescription() == null) ? 0 : getArticleDescription().hashCode());
        result = prime * result + ((getArticleContent() == null) ? 0 : getArticleContent().hashCode());
        result = prime * result + ((getArticleImage() == null) ? 0 : getArticleImage().hashCode());
        result = prime * result + ((getArticleView() == null) ? 0 : getArticleView().hashCode());
        result = prime * result + ((getArticleStatus() == null) ? 0 : getArticleStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", articleId=").append(articleId);
        sb.append(", articleType=").append(articleType);
        sb.append(", articleTitle=").append(articleTitle);
        sb.append(", articleDate=").append(articleDate);
        sb.append(", articleDescription=").append(articleDescription);
        sb.append(", articleContent=").append(articleContent);
        sb.append(", articleImage=").append(articleImage);
        sb.append(", articleView=").append(articleView);
        sb.append(", articleStatus=").append(articleStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}