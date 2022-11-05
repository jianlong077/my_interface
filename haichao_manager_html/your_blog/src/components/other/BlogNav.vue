<template>
  <div class="header-nav-box">
    <div class="header-nav-box-1">
    </div>
    <div class="header-nav-box-2">

      <div class="header-nav-box-2-1">

        <router-link to="/LogEssayListTop">主页</router-link>
      </div>
      <div class="header-nav-box-2-1">

        <router-link to="/LogEssayList">文章列表</router-link>
      </div>
      <div class="header-nav-box-2-1">

        <router-link to="LogEssayView">详情</router-link>
      </div>
      <div class="header-nav-box-2-1">

        <router-link to="/LogEssayWrite">写作</router-link>
      </div>
      <div class="header-nav-box-2-2">
        <el-input v-model="input2.a"
                  :suffix-icon="Search"
        />
      </div>
    </div>
    <div class="header-nav-box-1">
      <div class="header-nav-box-1-1">
        <router-link to="/">登录</router-link>
        /
        <router-link to="/">注册</router-link>
      </div>
    </div>
  </div>
</template>

<script setup>
import {reactive} from 'vue'
import {Search} from '@element-plus/icons-vue'

const input2 = new reactive({})
input2.a = 'nihao';
</script>

<style scoped lang="scss">
.header-nav-box {
  border-bottom: 0;
  width: 100%;
  height: 50px;
  background-color: rgba(0, 0, 0, .4);

  .header-nav-box-1 {
    width: 21.3%;
    max-width: 250px;
    height: 100%;
    float: left;

    .header-nav-box-1-1 {
      margin-top: 15px;
      margin-left: 120px;
      height: 55%;
      color: white;

      a {
        color: white;
        cursor: pointer;
        text-decoration: none;
      }

      a:hover {
        color: #CCCCD8;
      }
    }
  }

  .header-nav-box-2 {
    min-width: 910px;
    width: 57.4%;
    height: 100%;
    float: left;

    .header-nav-box-2-1 {
      cursor: pointer;
      padding-left: 10px;
      float: left;
      width: 140px;
      display: inline-block;
      height: 100%;
      align-items: center;
      text-align: center;
      display: flex;

      a:-webkit-any-link {
        width: 100%;
        color: #ffffff !important;
        font-size: 18px !important;
        text-decoration: none;
      }
    }

    .header-nav-box-2-1:hover {
      -webkit-box-shadow: #ccc 2px 2px 2px 2px;
      -moz-box-shadow: #ccc 2px 2px 2px 2px;
      box-shadow: #ccc 2px 2px 2px 2px;

      span {
        color: #CCCCD8;
      }
    }

    .header-nav-box-2-2 {
      float: right;
      width: 330px;
      height: 100%;
      padding-top: 10px;

      .el-input {
        height: 80%;
      }
    }
  }
}
</style>