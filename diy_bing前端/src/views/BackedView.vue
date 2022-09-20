<template>
  <div class="back-view">
  <NavLeft class="navLeft"></NavLeft>
  <NavTop class="navLeft"></NavTop>
  
  </div>
</template>

<script>
import NavLeft from "../components/NavLeft.vue";
import NavTop from "../components/NavTop.vue";
export default {
  components: { NavLeft, NavTop },
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
  },
};
</script>

<style scoped>
.back-view{
  all: initial;
  /* text-align: left; */
}
.navLeft {
  display: block;
  float: left;
}
.navTop {
  display:  inline-block;
  /* float: right; */
  /* width: 300px; */
}
</style>