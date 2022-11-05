<template>
  <div class="el-header">
    <!--    顶部标签-->
    <BlogNav/>
  </div>
</template>

<script setup>
import {defineAsyncComponent} from 'vue'

const BlogNav = defineAsyncComponent(() => import('@/components/other/BlogNav.vue'))
</script>

<style lang="scss" scoped>
.el-header {
  padding-left: 0px!important;
  padding-right: 0px!important;;
  width: 100%;
  background-image: url("@/assets/导航背景图1.jpg");
  background-size: 100% 100%;
  position:relative;
  .header-nav-box{
    position:absolute;
    width: 100%;
    bottom:0px;
  }
}
</style>