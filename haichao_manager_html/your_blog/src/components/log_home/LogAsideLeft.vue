<template>
  <div class="el-aside">
    <!--    时间-->
    <DayBox/>

  </div>
</template>

<script setup>
import {defineAsyncComponent} from 'vue'

const DayBox = defineAsyncComponent(() => import('@/components/other/DayBox.vue'))


</script>

<style lang="scss">
.aside-Left-box{

  width: 70%;
  border-bottom-width: 10px;
  border-right-width: 10px;
  padding: 10px 10px 5px;
  background-color: #FFFFFF;
  .aside-Left-box-1{
    background-color: #F3F5F7;
  }
}
</style>