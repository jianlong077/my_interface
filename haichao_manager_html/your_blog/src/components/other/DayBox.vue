<template>
  <div class="aside-Left-box">
    <el-calendar v-model="dayData" height="0px">
    </el-calendar>
  </div>
</template>

<script setup>
import {reactive} from 'vue'
const dayData = reactive(new Date())
</script>

<style  lang="scss">
.aside-Left-box {
  float: right;
  .el-calendar {
    --el-calendar-cell-width: 25px;
    .el-calendar__header{
      padding-left: 5px;padding-right: 5px;
    }
    .el-calendar__body{
      padding-top: 3px;
      height: 220px;
      .el-calendar-table{
      }
    }
  }

}

.el-button{
  padding-left: 5px;padding-right: 5px;
}
/*.el-calendar__body {
  padding-left: 5px!important;
  padding-right: 5px!important;
  padding-bottom: 5px!important;
  padding-top: 5px!important;
}*/

</style>