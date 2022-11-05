<template>
  <div class="aside-Left-box">
    <div class="aside-Left-box-1">
      <div class="aside-Left-box-1-1"><span>评论</span></div>
      <div class="aside-Left-box-1-2">
        <div class="aside-Left-box-1-2-1" v-for='index in 10' :key='index'><span>标签-{{index}}</span></div>

      </div>
    </div>
  </div>
</template>

<script setup>
</script>

<style scoped lang="scss">
.aside-Left-box {
  width: 70%;
  float: left;
  .aside-Left-box-1 {
    width: 100%;

    .aside-Left-box-1-1 {
      padding-top: 5px;
      width: 100%;
      height: 35px;
      background-image: url("@/assets/首部标签.png");
      background-size: 100% 100%;
    }

    .aside-Left-box-1-2 {
      width: 100%;
      min-height: 180px;
      .aside-Left-box-1-2-1{
        cursor: pointer;
        height:40px;
        border-bottom:1px dashed #162B42;
        padding: 9px 5px 5px;
        background-color: #FFFFFF;
        max-height: 80px;
        span{
          float: left;
        }
      }
      .aside-Left-box-1-2-1:hover {
        -webkit-box-shadow: #ccc 5px 5px 5px;
        -moz-box-shadow: #ccc 5px 5px 5px;
        box-shadow: #ccc 5px 5px 5px;
        span{
          color: #CCCCD8;
        }
      }
    }
  }
}
</style>