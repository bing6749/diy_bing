<template>
  <div>
    <NavLeft class="navLeft"></NavLeft>
    <NavTop class="navTop"></NavTop>
    <div>
      <div>
        <el-input
          v-model="pagination.queryString"
          style="width: 200px; margin-right: 10px"
          size="mini"
          @keydown.enter.native="findPage()"
          placeholder="输入关键字搜索"
        />

        <el-button
          size="small"
          type="primary"
          style="margin-right: 50px"
          class="butT"
          @click="findPage()"
          >搜索</el-button
        >
        <el-button
          size="small"
          type="primary"
          class="butT"
          @click="handleCreate()"
          >新建文章</el-button
        >
      </div>
      <el-table
        :data="dataList"
        size="small"
        stripe
        highlight-current-row
        style="width: 85%"
      >
        <el-table-column label="文章序号" prop="articleId"> </el-table-column>
        <el-table-column label="文章标题" prop="articleTitle">
        </el-table-column>
        <el-table-column label="文章设置" align="right">
          <!-- <template slot="header">
            
          </template> -->
          <template slot-scope="scope">
            <el-button size="mini" @click="handleUpdate(scope.row.articleId)"
              >Edit</el-button
            >
            <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.row.articleId)"
              >Delete</el-button
            >
          </template>
        </el-table-column>
      </el-table>

      <el-pagination
        style="float: right;margin-right: 90px;"
        @current-change="handleCurrentChange"
        :current-page="pagination.currentPage"
        :page-size="pagination.pageSize"
        layout="prev, pager, next"
        :total="pagination.total"
      >
      </el-pagination>
    </div>

    <!-- 编辑标签弹层 -->
    <div>
      <el-dialog
        fullscreen="true"
        :visible.sync="dialogFormVisible4Edit"
        title="编辑文章页"
      >
        <el-form :model="formData" ref="dataEditForm">
          <el-form-item label="文章标题：" label-width="100px">
            <el-input
              v-model="formData.articleTitle"
              autocomplete="off"
            ></el-input
          ></el-form-item>

          <el-form-item label="文章日期：" label-width="100px">
            <el-date-picker
              type="date"
              placeholder="选择日期"
              v-model="formData.articleDate"
              style="width: 100%"
            ></el-date-picker
          ></el-form-item>

          <el-form-item label="文章简介：" label-width="100px">
            <el-input
              type="textarea"
              v-model="formData.articleDescription"
            ></el-input>
          </el-form-item>
          <el-form-item label="文章图片：" label-width="100px">
            <el-input v-model="formData.articleImage"></el-input>
          </el-form-item>
          <el-form-item label="文章内容：" label-width="100px">
            <mavon-editor
              v-model="formData.articleContent"
              style="height: 550px"
            />
          </el-form-item>
          <el-form-item style="margin-left: 100px">
            <el-button type="primary" @click="handleEdit()">修改</el-button>
            <el-button
              style="margin-left: 30px"
              @click="dialogFormVisible4Edit = false"
              >取消</el-button
            >
          </el-form-item>
        </el-form>
      </el-dialog>
    </div>

    <!-- 新建文章 -->
    <div>
      <el-dialog
        fullscreen="true"
        :visible.sync="dialogFormVisible"
        title="新建文章页"
      >
        <el-form :model="formData" ref="dataAddForm"
        :rules="rules">
          <el-form-item label="文章标题：" label-width="100px" prop="articleTitle">
            <el-input
              v-model="formData.articleTitle"
              autocomplete="off"
            ></el-input
          ></el-form-item>

          <el-form-item label="文章日期：" label-width="100px" prop="articleDate">
            <el-date-picker
              type="date"
              placeholder="选择日期"
              v-model="formData.articleDate"
              style="width: 100%"
            ></el-date-picker
          ></el-form-item>

          <el-form-item label="文章简介：" label-width="100px"  prop="articleDescription">
            <el-input
              type="textarea"
              v-model="formData.articleDescription"
            ></el-input>
          </el-form-item>
          <el-form-item label="文章图片：" label-width="100px" prop="articleImage">
            <el-input v-model="formData.articleImage"></el-input>
          </el-form-item>
          <el-form-item label="文章内容：" label-width="100px">
            <mavon-editor
              v-model="formData.articleContent"
              style="height: 550px"
            />
          </el-form-item>
          <el-form-item style="margin-left: 100px">
            <el-button type="primary" @click="handleAdd()">添加</el-button>
            <el-button
              style="margin-left: 30px"
              @click="dialogFormVisible = false"
              >取消</el-button
            >
          </el-form-item>
        </el-form>
      </el-dialog>
    </div>

  </div>
</template>

<script>
import NavLeft from "../components/NavLeft.vue";
import NavTop from "../components/NavTop.vue";
export default {
  data() {
    return {
      pagination: {
        //分页相关模型数据
        currentPage: 1, //当前页码
        pageSize: 9, //每页显示的记录数
        total: 0, //总记录数
        queryString: "", //查询条件
      },
      dataList: [], //当前页要展示的分页列表数据
      formData: {}, //表单数据
      dialogFormVisible: false, //增加表单是否可见
      dialogFormVisible4Edit: false, //编辑表单是否可见
      dataAddForm:{
        articleTitle:'',
        articleDate:'',
        articleDescription:'',
        articleImage:'',
      },
      rules: {
        articleTitle: [
          { required: true, message: '请输入文章', trigger: 'blur' },
        ],
        articleDate:[    
            { type: 'date', required: true, message: '请选择日期', trigger: 'blur' },
        ],
        articleDescription:[    
            { required: true, message: '请输入文章简介', trigger: 'blur' },
        ],
        articleImage:[    
            { required: true, message: '请输入文章封面', trigger: 'blur' },
        ],
        // articleContent:[    
        //     { required: true, message: '请输入文章正文', trigger: 'blur' },
        // ],
      }
    };
  },
  created() {
    this.findPage(); //vue对象初始化完成之后调用分页方法
  },
  methods: {
    //获取文章数据
    findPage() {
      var param = {
        currentPage: this.pagination.currentPage,
        pageSize: this.pagination.pageSize,
        queryString: this.pagination.queryString,
      };
      // param.currentPage =
      // param.queryString != '' ? 1 : this.pagination.currentPage;
      this.axios.post("/article/findAllArticle", param).then((res) => {
        console.log(res);
        //解析controller响应回的数据,为模型数据赋值，基于VUE的双向绑定展示到页面
        this.pagination.total = res.total;
        this.dataList = res.rows;
      });
    },
    //切换页码
    handleCurrentChange(currentPage) {
      this.pagination.currentPage = currentPage;
      console.log(this.pagination.queryString);
      this.findPage();
    },
    //删除判断
    handleDelete(row) {
      //alert(row.id);
      this.$confirm("将永久删除该文章，是否继续?", "提示", {
        type: "warning",
      })
        .then(() => {
          console.log(row);
          this.axios.get("/article/deleteArticleById?id=" + row).then((res) => {
            if (res.flag) {
              this.$message({
                type: "success",
                message: res.message,
              });
              this.findPage();
            } else {
              this.$message.error(res.message);
            }
          });
        })
        .catch(() => {
          // alert('取消按钮');
          this.$message({
            type: "info",
            message: "操作已取消",
          });
        });
    },
    //弹出编辑窗口
    handleUpdate(id) {
      this.dialogFormVisible4Edit = true;
      this.axios.get("/article/findArticleById?id=" + id).then((res) => {
        if (res.flag) {
          this.formData = res.data;
          console.log(this.formData);
        } else {
          this.$message.error(res.message);
        }
      });
    },
    // 重置表单
    resetForm() {
        this.formData = {}; //用来重置数据
    },
    //编辑
    handleEdit() {
      this.$refs["dataEditForm"].validate((valid) => {
        if (valid) {
          this.axios
            .post("/article/editArticle", this.formData)
            .then((res) => {
              console.log(res);
              if (res.flag) {
                //弹出提示信息
                this.$message({
                  message: res.message,
                  type: "success",
                });
              } else {
                this.$message.error(res.message);
              }
            })
            .finally(() => {
              this.dialogFormVisible4Edit = false;
              this.findPage();
            });
          console.log(valid);
        } else {
          this.$message.error("表单数据校验失败！");
          return false;
        }
      });
    },
    //添加
    handleAdd() {
      this.$refs["dataAddForm"].validate((valid) => {
        if (valid) {
          console.log(this.formData);
          this.axios
            .post("/article/addArticle", this.formData)
            .then((res) => {
              // console.log(res);
              if (res.flag) {
                //弹出提示信息
                this.$message({
                  message: res.message,
                  type: "success",
                });
              } else {
                this.$message.error(res.message);
              }
            })
            .finally(() => {
              this.dialogFormVisible = false;
              this.findPage();
            });
          console.log(valid);
        } else {
          this.$message.error("表单数据校验失败！");
          return false;
        }
      });
    },
    // 弹出添加窗口
    handleCreate() {
        this.dialogFormVisible = true;
        this.resetForm();
    },
  },
  components: { NavLeft, NavTop },
};
</script>

<style>
</style>