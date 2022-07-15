<template>
  <div class="footer">
  <div class="footer-nav">
    <a href="/aboutus" target="_blank">关于我们</a>
    <i class="hr"></i>
    <a href="/joinus" target="_blank">加入我们</a>
    <i class="hr"></i>
    <a href="/copyright" target="_blank">版权保护</a>
    <i class="hr"></i>
    <a href="/cooperation" target="_blank">内容合作</a>
  </div>
  <p class="cp">
    <a href="https://beian.miit.gov.cn" target="_blank">浙ICP备2021040600号</a>
    &nbsp;Copyright©2022-2022&nbsp;王晨冰个人所有&nbsp;Designed by DIY冰工坊 
  </p>
</div>
</template>

<script>
export default {
  
  methods: {
    // footerAuto() {
    //     var _wh = $(window).height();
    //     var _dh = $(document).height();
    //     var _bh = $(document.body).height();
    //     if (_bh < _wh) {
    //         $("#footer").css({
    //             position: "fixed",
    //             bottom: "0",
    //             left: "0",
    //         })
    //     } else {
    //         $("#footer").css({
    //             position: "static",
    //             bottom: "auto",
    //             left: "auto",
    //         })
    //     }
    // }
  }
}

</script>
<style>
.footer .footer-nav a {
    margin: 0 10px;
}

.footer {
    height: 93px;
    margin-top: 30px;
    border-top: 1px solid #eee;
    padding: 24px;
    background-color: #fff;
    text-align: center;
    font-size: 14px;
    color: #999;
}
a {
    text-decoration: none;
    color: inherit;
}
</style>