<template>
  <div class="card">
    <h2 class="card-title">
      <img
        class="title-image"
        src="https://static-public.infinitytab.com/onesite-client/images/recommend.png?v=2.3.5"
        alt="recommend"
      /><span>{{typeName}}</span>
    </h2>

    <el-row class="row" :gutter="100">
      <el-col
        :span="24"
        v-for="item in articles"
        :key="item.index"
        :offset="(index = 0)"
      >
        <el-card
          style="border-radius: 16px"
          :body-style="{ padding: '0px' }"
          shadow="hover"
          class="card"
        >
          <div class="article-item">
            <div class="p-3 article-item-top">
              <router-link
                target="_blank"
                :to="{ path: '/articles/' + item.articleId }"
                ><img
                  @click="setArticle(item)"
                  height="88px"
                  width="124px"
                  :src="item.articleImage"
                  :alt="item.articleTitle"
                  loading="lazy"
                  style="float: left"
                  :title="item.articleTitle"
              /></router-link>
              <div class="ms-3 article-info">
                <router-link
                  target="_blank"
                  :to="{ path: '/articles/' + item.articleId }"
                  ><h3 class="m-0 article-title" @click="setArticle(item)">
                    {{ item.articleTitle }}
                  </h3></router-link
                >
                <el-tags class="article-tag">
                  <el-tag
                    v-for="tag in item.tags"
                    :key="tag.index"
                    class="el-article-tag"
                    type="info"
                    size="mini"
                    >{{ tag.tagName }}</el-tag
                  >
                </el-tags>
                <div class="article-remark">
                  <span>{{ item.articleDate }}</span>
                  <i class="el-icon-view"></i
                  ><span>{{ item.articleView }}</span>
                </div>
              </div>
            </div>
            <div class="article-bottom">
              <hr class="hr-set" style="" />
              <div class="article-description overflow-ellispsis2">
                {{ item.articleDescription }}
              </div>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  data() {
    return {
      articles: [],
    };
  },
  props:['typeName','type'],
  created() {
    this.findArticlesByType();
  },
  methods: {
    findArticlesByType() {
      this.axios.get("/article/findArticles?type=" + this.type).then((res) => {
        console.log(res);
        if (res.flag) {
          this.articles = res.data;
          console.log(this.articles);
        }
      });
      
    },
    setArticle(param) {
      // console.log(param);

      localStorage.setItem("article" + param.articleId, JSON.stringify(param));
    },
  },
};
</script>

<style>
.card-title {
  text-align: left;
  height: 32px;
  font-size: 20px;
  font-weight: 500;
  color: #11143b;
  line-height: 32px;
  display: flex;
  margin-top: 50px;
  margin-left: 10px;
  /* margin-bottom: 20px; */
  font-family: PingFangSC-Medium, PingFang SC;
}
.card {
  text-align: left;
  padding-top: 40px;
  font-family: PingFangSC-Regular, PingFang SC;
}
h2 {
  margin-block-start: 0.83em;
  margin-block-end: 0.83em;
  margin-inline-start: 0px;
  margin-inline-end: 0px;
}
.row > * {
  flex-shrink: 0;
  width: 100%;
  max-width: 100%;
  padding-right: calc(var(--bs-gutter-x) * 0.5);
  padding-left: calc(var(--bs-gutter-x) * 0.5);
  margin-top: var(--bs-gutter-y);
  text-align: center;
  font-size: 14px;
  padding-top: 50px;
}
.card {
  height: 192px;
  border-radius: 25px;
  transition: box-shadow 2s;
  padding-top: 0px;
}
h3 {
  margin-block-start: 1em;
  margin-block-end: 1em;
  margin-inline-start: 0px;
  margin-inline-end: 0px;
}
/* card内文字适应 */
.article-title {
  font-size: 16px;
  font-weight: 500;
  line-height: 24px;
  color: #11143b;
  font-family: PingFangSC-Medium, PingFang SC;
}
.article-item .article-item-top .article-info {
  flex: 1;
  text-align: left;
  overflow: hidden;
}
.article-item .article-bottom .article-description {
  text-align: left;
  font-size: 13px;
  font-weight: 400;
  color: #8e8f9b;
  line-height: 18px;
}
.article-description {
  text-overflow: ellipsis;
}
.article-item {
  padding: 16px;
}
.article-bottom {
  display: flex;
  flex-flow: column;
  float: left;
  clear: left;
}
.article-info {
  margin-left: 12px;
  float: left;
}
.hr-set {
  display: block;
  height: 1px;
  width: 100%;
  margin: 10px 0 8px 0;
  background: #ffffff;
  border-bottom: none;
  border-top: 2px solid #9fa0b4;
}
/* 文章标签样式 */
.el-article-tag {
  margin-top: 4px;
  margin-right: 4px;
  padding-right: 6px;
}
.article-title:hover {
  color: #f66d6d !important;
}
.article-remark {
  margin-top: 5px;
  color: #9fa0b4;
  line-height: 20px;
  font-size: 12px;
  font-weight: 400;
  display: flex;
}
.el-icon-view {
  color: #9fa0b4;
  line-height: 20px;
  text-align: center;
  margin: auto 2px auto 5px;
}
</style>