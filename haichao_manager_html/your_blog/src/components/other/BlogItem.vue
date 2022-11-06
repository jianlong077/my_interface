<template>
  <div class="box" v-for="item in data.data" :key="item">
    <div class="main_box" >
      <div class="left"><img src="@/assets/3.jpg"></div>
      <div class="right">
        <div class="top" @click="toShowDetail(item.cguid)"><h2>{{item.name}}</h2></div>
        <div class="footer"><p>{{item.remark}}</p></div>
      </div>
    </div>
    <div class="label-box">标签：科技</div>
  </div>
</template>

<script setup>
import {ref, onMounted, reactive, inject} from 'vue'
import {  useRouter } from 'vue-router'
import {findLogTop} from "@/components/util/request";
//初始化响应式参数
const data = reactive({data: {}})
const router = useRouter()
//默认执行方法
onMounted(() => {
  findlogs();
})
//方法
const findlogs = () => {
  findLogTop({}).then(function (response) {
    data.data=response;
    console.log(data);
  }).catch(function (error) {
        console.log(error);
  }).finally(function () {
        // 总是会执行
  });
}
const toShowDetail=(cguid)=>{
  router.push({name:"文章查看",params: {id :cguid}})
}
</script>

<style scoped lang="scss">
.box {
  height: 160px;
  width: 100%;
  margin-top: 20px;
  position: relative;

  .main_box {
    margin-left: 16px;
    z-index: 1;
    position: absolute;
    height: 100%;
    width: calc(100% - 32px);
    background-color: #FFFFFF;

    .left {
      float: left;
      height: 100%;
      width: 20%;

      img {
        width: auto;
        height: 100%;
        width: 100%;
      }
    }

    .right {
      float: right;
      height: 100%;
      width: 80%;

      .top {
        cursor: pointer;
        height: 35%;
        width: 100%;

        h2 {
          padding-top: 1%;
        }
      }

      .footer {
        height: 65%;
        width: 100%;
        border-top: 2px dashed #ffffff;

        p {
          padding-top: 10px;
        }
      }
    }
  }

  .label-box {
    position: absolute;
    z-index: 2;
    margin-top: 20px;
    height: 26px;
    padding: 0 20px 0 30px;
    background-color: #478591;
    border-radius: 0 3px 3px 0;
    color: #fff;
    font-size: 14px;
    line-height: 26px;
  }

  .label-box::after {
    position: absolute;
    bottom: -12px;
    left: 5px;
    display: block;
    content: '';
    height: 0;
    border: 12px solid #2f5860;
    border-color: transparent transparent transparent #2f5860;
    transform: rotate(-45deg);
  }
}

.main_box:hover {
  -webkit-box-shadow: #ccc 10px 10px 10px;
  -moz-box-shadow: #ccc 10px 10px 10px;
  box-shadow: #ccc 10px 10px 10px;
}

</style>