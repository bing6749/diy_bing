<template>
  <div>
    <NavLeft class="navLeft"></NavLeft>
    <NavTop class="navTop"></NavTop>
    <el-card class="panelCard">
      <div id="CPU-Dashboard" style="height:300px;width:300px;margin-left: 170px;border-radius: 25px;float: left;  display: block;">
        <!-- <h1>仪表盘</h1> -->
      </div>
      
      <div id="GPU-Dashboard" style="height:300px;width:300px;margin-right: 170px;border-radius: 25px;float: right; display: block;">
        <!-- <h1>仪表盘</h1> -->
      </div>
      
    </el-card>
  </div>
</template>

<script>
import NavLeft from "../components/NavLeft.vue";
import NavTop from "../components/NavTop.vue";
export default {
  data() {
    return {
      option: [],
      option2: [],
      cpuCount: {
        intel: "0",
        AMD: "0",
      },
      gpuCount: {
        Nvidia: "212",
        AMD: "232",
      },
    };
  },
  methods: {
    async drawChart() {
      await this.axios("product/findCPUProductCount").then((res) => {
        if (res.flag) {
          console.log(res.data);
          this.cpuCount = res.data;
        }
      });
      await this.axios("product/findGPUProductCount").then((res) => {
        if (res.flag) {
          console.log(res.data);
          this.gpuCount = res.data;
        }
      });


      this.option = {
        backgroundColor: "#fffeff",
        title: {
          text: "CPU数量分布",
          left: "center",
          top: 20,
          textStyle: {
            color: "#585677",
          },
        },
        tooltip: {
          trigger: "item",
        },
        visualMap: {
          show: false,
          min: 80,
          max: 600,
          inRange: {
            colorLightness: [0, 1],
          },
        },
        series: [
          {
            name: "CPU数",
            type: "pie",
            radius: "60%",
            center: ["50%", "50%"],
            data: [
              { value: this.cpuCount.intel, name: "intel",itemStyle: {color:'#3112fc'} },
              { value: this.cpuCount.AMD, name: "AMD",itemStyle: {color:'#fc2a05'} },
            ].sort(function (a, b) {
              return a.value - b.value;
            }),
            roseType: "radius",
            label: {
              color: "rgba(0,0,0)",
              normal: {
                show: true,
                position: 'inner', // 数值显示在内部
                formatter: '{b}: {c}', // 格式化数值百分比输出
              },
            },
            labelLine: {
              lineStyle: {
                color: "rgba(0,0,0)",
              },
              smooth: 0.2,
              length: 10,
              length2: 20,
            },
            itemStyle: {
              borderWidth:1,
              normal: {
                color: function (colors) {
                  var colorList = [
                    '#fc8251',
                    '#5470c6',
                  ];
                return colorList[colors.dataIndex];
              }
            },
              color: "#c23531",
              shadowBlur: 200,
              shadowColor: "rgba(0, 0, 0, 0.9)",
            },
            animationType: "scale",
            animationEasing: "elasticOut",
          },
        ],
      };
      let CPUEchart = this.$echarts.init(
        document.getElementById("CPU-Dashboard")
      );
      CPUEchart.setOption(this.option);

      this.option2 = {
        backgroundColor: "#fffeff",
        title: {
          text: "GPU数量分布",
          left: "center",
          top: 20,
          textStyle: {
            color: "#585677",
          },
        },
        tooltip: {
          trigger: "item",
        },
        visualMap: {
          show: false,
          min: 80,
          max: 600,
          inRange: {
            colorLightness: [0, 1],
          },
        },
        series: [
          {
            name: "GPU数",
            type: "pie",
            radius: "60%",
            center: ["50%", "50%"],
            data: [
              { value: this.gpuCount.Nvidia, name: "Nvidia",itemStyle: {color:'#2a9e00'} },
              { value: this.gpuCount.AMD, name: "AMD",itemStyle: {color:'#fc2a05'} },
            ].sort(function (a, b) {
              return a.value - b.value;
            }),
            roseType: "radius",
            label: {
              color: "rgba(0,0,0)",
              normal: {
                show: true,
                position: 'inner', // 数值显示在内部
                formatter: '{b}: {c}', // 格式化数值百分比输出
              },
            },
            labelLine: {
              lineStyle: {
                color: "rgba(0,0,0)",
              },
              smooth: 0.2,
              length: 10,
              length2: 20,
            },
            itemStyle: {
              borderWidth:1,
              normal: {
                color: function (colors) {
                  var colorList = [
                    '#fc8251',
                    '#5470c6',
                  ];
                return colorList[colors.dataIndex];
              }
            },
              color: "#c23531",
              shadowBlur: 200,
              shadowColor: "rgba(0, 0, 0, 0.9)",
            },
            animationType: "scale",
            animationEasing: "elasticOut",
          },
        ],
      };
      let GPUEchart = this.$echarts.init(
        document.getElementById("GPU-Dashboard")
      );
      GPUEchart.setOption(this.option2);
    },
  },
  created() {
  },
  mounted() {
    this.drawChart();
  },
  components: { NavLeft, NavTop },
};
</script>

<style>
.panelCard{
  margin: 30px 20px;
}
</style>