<template>
  <div class="block">
    <el-carousel height="400px" trigger="click" class="carousel-inner">
      <el-carousel-item
        v-for="item in imageList"
        :key="item.value"
        class="carousel-item"
      >
      <router-link :to="item.link">
        <!-- <h3 class="small">{{ item }}</h3> -->
          <img class="carousel-img" :src="item.url" alt="" />
        </router-link>
      </el-carousel-item>
    </el-carousel>

    
  </div>
</template>
<script src="//www1.pconline.com.cn/2021/diy/tiantitu/js/echarts.min.js"></script>
<script>

export default {
  data: function () {
    return {
      imageList: [
        {
          url: "https://img0.baidu.com/it/u=2919102411,1018598751&fm=253&fmt=auto&app=120&f=JPEG?w=800&h=450",
          link: "CPURank",
        },
        {
          url: "https://img1.baidu.com/it/u=1130795261,1205275899&fm=253&fmt=auto&app=138&f=PNG?w=864&h=488",
          link: "GPURank",
        },
        {
          url: "https://img2.baidu.com/it/u=3780957042,3167162479&fm=253&fmt=auto&app=138&f=JPEG?w=480&h=300",
          link: "tampermonkey",
        },
      ],
    };
  },
};
</script>

<style>
/* .el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
} */
.block{
  margin-top: 50px;
}
.carousel-inner {
  position: relative;
  width: 100%;
  overflow: hidden;
    /* background: #F7F7FA; */
}
.carousel-item {
  position: relative;
  display: none;
  width: 100%;
  margin-right: -100%;
  -webkit-backface-visibility: hidden;
  backface-visibility: hidden;
  transition: transform 0.6s;
  text-align: center;
}
.carousel-img {
  height: 100%;
  border-radius: 16px;
  background-repeat: no-repeat;
  background-position: center;
  background-size: cover;
}
</style>