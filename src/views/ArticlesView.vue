<template>
  <div class="container-body">
    <div class="index">
      <div class="breadcrumb">
        <el-breadcrumb separator-class="el-icon-arrow-right">
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item
            class="breadcrumb-current"
            :to="{ path: '/articles' }"
            >文章咨讯</el-breadcrumb-item
          >
        </el-breadcrumb>
      </div>
      <div class="content-body">
        <article class="p-md-5 p-4 article-body" data-id="1717">
          <header>
            <h1 class="article-title-inner">
              {{ article.articleTitle }}
            </h1>
            <div class="article-info-content">
              <span class="article-author">发布者：Bing</span
              ><span class="article-views">
                <i class="el-icon-view"></i
                ><span>{{ article.articleView }}</span></span
              >
              <div class="article-pushdate">{{ article.articleDate }}</div>
            </div>
          </header>
          <div class="app-ad s-ad">
            <!-- 扩展迷-文章详情页固定广告1 -->
          </div>
          <div class="summary">
            <p class="m-0">
              {{ article.articleDescription }}
            </p>
          </div>
          <div class="tag-item-body">
            <el-tags class="article-tag-inner">
              <el-tag
                v-for="tag in article.tags"
                :key="tag.index"
                class="el-article-tag"
                type="info"
                >{{ tag.tagName }}</el-tag
              >
            </el-tags>
          </div>
          <!-- <div class="article-body" id="editor">
          {{article.articleContent}}
          
        </div> -->

          <div v-html="markdownToHtml" class="article-body"></div>
        </article>
      </div>
    </div>
  </div>
</template>

<script>

import * as demo from "marked";
export default {
  data() {
    return {
      articleId: "",
      article: {},
    };
  },
  created() {
    this.getArticle();
  },
  mounted() {

  },
  methods: {
    getArticle() {
      var url = window.location.pathname;
      this.articleId = url.substring(url.lastIndexOf("/") + 1, url.length);
      this.article = JSON.parse(
        localStorage.getItem("article" + this.articleId)
      );
      console.log(this.article);
      console.log(this.articleId);
      this.axios.put("/article/addView?articleId="+this.articleId).then((res) =>{
        console.log(res);
      });
    },
  },
  computed: {
    markdownToHtml() {
      // console.log(this.article.articleContent);
      return demo.marked(this.article.articleContent);
    },
  },
  beforeDestroy() {
    localStorage.removeItem("article" + this.articleId);
  },
};
</script>

<style scoped>
.container-body {
  width: 100%;
  padding-right: var(--bs-gutter-x, 0.75rem);
  padding-left: var(--bs-gutter-x, 0.75rem);
  margin-right: auto;
  margin-left: auto;
  margin: 0;
  padding-top: 1.5rem !important;
  padding-bottom: 1.5rem !important;
  background: #f8f8fa;
  font-family: PingFang SC;
  /* position: relative; */
  display: flex;
  height: auto;
  justify-content: center;
}

.article-body p {
  text-align: left;
}

img {
  width: 50%;
  /* text-align: center; */
}
.index {
  margin-left: 80px;
  margin-right: 80px;
  display: block;
}
.breadcrumb {
  margin: 30px auto;
  font-size: 18px;
  /* text-align: center; */
}
.el-breadcrumb .breadcrumb-current .el-breadcrumb__inner {
  color: #f55a5a !important;
  font-weight: 200;
  /* font-size: 16px; */
  line-height: 1;
  cursor: not-allowed !important;
}
.content-body {
  /* text-align: left; */
  /* margin-top: 30px; */
  /* float: left; */
  width: 100vh;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;

  margin-top: 60px;


  display: block;
  background-color: #fff;
  border-radius: 25px;
  transition: box-shadow 2s;
  padding: 48px;
}
.article-title-inner {
  margin: 0;
  font-size: 34px;
  font-weight: 500;
  color: #11143b;
  box-sizing: border-box;
  text-align: center;
  line-height: 33px;
  font-family: PingFangSC-Medium, PingFang SC;
}
.article-info-content {
  margin-top: 18px;
  margin-bottom: 18px;
  font-size: 18px;
  font-weight: 400;
  color: #9fa0b4;
}
.article-author {
  font-size: 18px;
}
.article-views {
  float: right;
}
.article-pushdate {
  float: right;
  margin-right: 20px;
}
.summary {
  color: #9fa0b4;
  font-size: 14px;
  text-align: left;
  background: #f5f5fa;
  border-radius: 8px;
  padding: 1rem !important;
  margin-top: 1.5rem !important;
  margin-bottom: 0.5rem !important;
}
.article-tag-inner {
  display: inline-block;
  padding: 4px 6px;
  /* background: #9FA0B4; */
  border-radius: 16px;
  font-size: 11px;
  font-weight: 400;
  /* color: #F5F5FA; */
  line-height: 16px;
}
.el-article-tag {
  margin-right: 20px;
}
</style>