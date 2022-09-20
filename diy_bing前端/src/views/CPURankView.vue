<template>
  <div>
    <div style="position: absolute; left: 50%; padding-top: 50px">
      <div class="cont-header mb10">
        <div
          class="Side lefeSide fl"
          title="点击单独查看该品牌数据"
          style="
            background: url(https://img0.pconline.com.cn/pconline/product/2101/28/intel.png);
            margin-right: 18px;
          "
        ></div>
        <div class="txtCont fl">
          <p class="stit">单击查看详细参数</p>
          <p class="desc">更新时间：<span id="JpubTime">2022-05-18</span></p>
          <p class="desc">数据来源：PConline</p>
        </div>
        <div
          class="Side rightSide fl"
          title="点击单独查看该品牌数据"
          style="
            background: url(https://img0.pconline.com.cn/pconline/product/2101/28/AMD.png);
            margin-left: 18px;
          "
        ></div>
      </div>
    </div>
    <div id="cpu-main"></div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      productid: 1302447,
      productdata: {},
      productList: [],
      option: [],
    };
  },
  methods: {
    async getOption() {
      // var that = this;
      await axios.get("api/product/findCPUProduct").then((res) => {
        if (res.data.flag) {
          this.productList = res.data.data;
          for (let i in this.productList) {
            // console.log(i);
            if (
              this.productList[i].brandid == 23834 &&
              this.productList[i].score > 0
            ) {
              this.productList[i].score = -this.productList[i].score;
            }
          }
          console.log(this.productList);
        }
      });
      this.drawChart();
      // console.log(this.$data);
    },
    drawChart() {
      console.log(this.$data);
      this.option = {
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "shadow",
          },
        },
        grid: {
          top: 80,
          bottom: 30,
          tooltip: {
            axisPointer: {
              type: "none",
            },
          },
        },
        xAxis: {
          show: false,
          type: "value",
          position: "top",
          splitLine: {
            show: false,
          },
        },
        // randiusAxis: {
        //     nameLocation: "center"
        // },
        yAxis: {
          show: false,
          type: "category",
          axisLine: {
            show: true,
            symbol: ["none", "arrow"],
            lineStyle: {
              color: "#333333", // 坐标轴线线的颜色
              width: 4,
            },
          },
          axisLabel: { show: false },
          axisTick: { show: false },
          splitLine: { show: false },
          inverse: true,
          data: this.productList.map((d) => d.productname),
        },
        series: [
          {
            name: "Score",
            type: "bar",
            stack: "Total",
            label: {
              show: true,
              formatter: "{b}",
            },
            itemStyle: {
              normal: {
                //这里设置柱形图圆角 [左上角，右上角，右下角，左下角]
                barBorderRadius: [5],
                color: function (params) {
                  // console.log(params);
                  var index_color = params.data;
                  if (index_color > 0) {
                    return "#e73823";
                  } else {
                    return "#0a73d6";
                  }
                },
              },
              emphasis: {
                color: "#4afdff",
                borderColor: "#111111",
                borderWidth: 2,
              },
            },
            data: this.productList.map((d) => d.score),
          },
        ],
        dataZoom: {
          show: true, // 为true 滚动条出现
          realtime: true,
          type: "slider", // 有type这个属性，滚动条在最下面，也可以不行，写y：36，这表示距离顶端36px，一般就是在图上面。
          height: 550, // 表示滚动条的高度，也就是粗细
          wtth: 20,
          start: 0, // 表示默认展示20%～80%这一段。
          end: 18,
          orient: "vertical",
          zoomLock: false,
        },
      };
      // console.log(this.productList);
      let myEchart = this.$echarts.init(document.getElementById("cpu-main"));

      let option = this.option;
      myEchart.setOption(option);
      // console.log(this.productList);
      // console.log(this.productList);
      let vm = this;
      myEchart.on("click", function (params) {
        let score = params.value;
        let name = params.name;
        if (score < 0) {
          score = -score;
        }
        vm.findProductPage(name);
      });
    },

    findProductPage: function (params) {
      console.log(params);
      for (let i in this.productList) {
        if (this.productList[i].productname == params) {
          this.productid = this.productList[i].productid;
        }
      }
      console.log(this.productid);
      axios
        .get(
          "/tiantitu/product_item.jsp?productId=" +
            this.productid +
            "&callback=jQuery110208086334041084586_1655252239465&_=1655252239469"
        )
        .then((res) => {
          console.log(res.data);
          var data = res.data.replace(/[\r\n]/g, "");
          // this.productdata = data.match(/\{(.+)\}/g)[0];
          this.productdata = JSON.parse(data.match(/\{(.+)\}/g)[0]).data;
          console.log(this.productdata);
          // var hxpl = '核心/线程';
          var pd =
            "CPU：" +
            this.productdata.name +
            "\n" +
            "频率：" +
            this.productdata.items[0].频率 +
            "Hz\n";
          if (this.productdata.items[2].生产工艺) {
            pd =
              pd +
              "生产工艺：" +
              this.productdata.items[2].生产工艺 +
              "nm" +
              "\n";
          }
          pd = pd + "接口类型：" + this.productdata.items[3].接口类型 + "\n";
          if (this.productdata.items[4].显示核心型号) {
            pd =
              pd +
              "显示核心型号：" +
              this.productdata.items[4].显示核心型号 +
              "\n";
          }
          if (this.productdata.items[5].工作功率) {
            pd = pd + "工作功率：" + this.productdata.items[5].工作功率 + "W";
          }
          this.$notify({
            position: "4",
            duration: 7000,
            message: pd,
            type: "success",
          });
        });
    },
  },
  created() {
    this.getOption();
  },
  mounted() {
    // this.drawChart();
  },
};
</script>
<style>
#cpu-main {
  width: 800px;
  height: 700px;
  margin: 90px auto 0 auto;
  /* background-color: #e8e8f0; */
}
.cont-header .Side {
  width: 200px;
  height: 100px;
  cursor: pointer;
  text-align: center;
}
.cont-header {
  margin: auto;
  padding: 0;
  height: 100px;
  position: relative;
  float: left;
  left: -50%;
}
.mb10 {
  margin-bottom: 10px;
}
.fl {
  float: left;
  display: inline;
  font: 12px/2em Microsoft Yahei, tahoma, HELVETICA;
}
.desc {
  font-size: 12px;
  color: #999999;
}
.stit {
  text-align: center;
  font: 15px/2em Microsoft Yahei, tahoma, HELVETICA;
}
</style>