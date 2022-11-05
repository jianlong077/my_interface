<template>
  <div class="common-layout">
    <LogHeader/>
    <div class="el-container">
      <LogAsideLeft/>
      <router-view/>
      <LogAsideRight/>
    </div>
    <LogFooter/>
    <!--    <el-container>
          <el-container direction="vertical">
            &lt;!&ndash; 顶部 &ndash;&gt;
            <LogHeader/>
            <el-container>
              &lt;!&ndash; 左部 AsideLeft&ndash;&gt;
              <LogAsideLeft/>
              <el-container direction="vertical">
                &lt;!&ndash; 中部 MainCenter&ndash;&gt;
                <LogMainCenter/>

              </el-container>
              &lt;!&ndash; 右部 &ndash;&gt;
              <LogAsideRight/>
            </el-container>
            &lt;!&ndash; 底部 Footer&ndash;&gt;
            <LogFooter/>
          </el-container>
        </el-container>-->
  </div>
</template>

<script setup>
import {defineAsyncComponent} from 'vue'

const LogHeader = defineAsyncComponent(() => import('@/components/log_home/LogHeader.vue')
)
const LogAsideLeft = defineAsyncComponent(() => import('@/components/log_home/LogAsideLeft.vue')
)
const LogMainCenter = defineAsyncComponent(() => import('@/components/log_home/LogMainCenter.vue')
)
const LogAsideRight = defineAsyncComponent(() => import('@/components/log_home/LogAsideRight.vue')
)
const LogFooter = defineAsyncComponent(() => import('@/components/log_home/LogFooter.vue')
)
</script>
<style lang="scss">
.common-layout {
  .el-header {
    width: 100%;
    height: 140px
  }

  .el-container {
    .el-aside {
      width:400px;
    }

    .el-main {
      width: 720px;
    }
  }

  .el-footer {
    background: #5f5ff5;
    width: 100%;
    height: 70px
  }
}

</style>
