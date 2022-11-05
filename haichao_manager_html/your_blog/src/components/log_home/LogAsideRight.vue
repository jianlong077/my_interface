<template>
  <el-aside>
    <!-- 个人展示 -->
    <MySelfShow/>
    <!--    最新文章-->
    <BlogHotList/>
    <!--    最新评论-->
    <BlogCommentsList/>
    <!--    标签-->
    <BlogTagList/>
  </el-aside>
</template>

<script setup>
import { defineAsyncComponent} from 'vue'

const MySelfShow = defineAsyncComponent(() => import('@/components/other/MySelfShow.vue'))
const BlogTagList = defineAsyncComponent(() => import('@/components/other/BlogTagList.vue'))
const BlogHotList = defineAsyncComponent(() => import('@/components/other/BlogHotList.vue'))
const BlogCommentsList = defineAsyncComponent(() => import('@/components/other/BlogCommentsList.vue'))
</script>

<style lang="scss" scoped>
</style>