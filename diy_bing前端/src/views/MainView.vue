<template>
  <div class="main-view">
      <carouselview></carouselview>
      <BingView typeName="文章资讯" type="1" ></BingView>
  </div>
</template>

<script>
import carouselview from './CarouselView.vue'
import BingView from './BingView.vue'
export default {
    components: { carouselview, BingView }
}
</script>

<style>
.main-view{
    padding-left:90px;
    padding-right:90px;
    /* background: #F7F7FA; */
}
</style>