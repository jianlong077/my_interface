<template>
  <div class="el-main">
    <div class="richText_main">


      <div class="text">
        <el-form :model="form" label-width="120px">
          <el-form-item label="文章标题：">
            <el-input v-model="form.name"/>
          </el-form-item>
          <el-form-item label="文章分类：">
            <el-input v-model="form.name"/>
          </el-form-item>
          <el-form-item label="文章标签：">
            <el-input v-model="form.name"/>
          </el-form-item>
          <el-form-item label="文章关键字：">
            <el-input v-model="form.name"/>
          </el-form-item>
        </el-form>


      </div>
      <div class="richText_button">
        <el-row class="mb-4">
          <el-button type="info">保存</el-button>
          <el-button type="warning" @click="getHowView">预览</el-button>
          <el-button type="danger">发布</el-button>
        </el-row>
      </div>
      <div id="richText" class="richText_c">


      </div>
    </div>

  </div>

  <el-drawer v-model="tableL.drawer" :show-close="false" size="50%">
    <template #header="{ close, titleId, titleClass }">
      <h4 :id="titleId" :class="titleClass">This is a custom header!</h4>
      <el-button type="danger" @click="close">
        <el-icon class="el-icon--left"><CircleCloseFilled /></el-icon>
        Close
      </el-button>
    </template>
    <div v-html="tableL.view"></div>
  </el-drawer>
</template>

<script setup>
import {ref, onMounted, reactive} from 'vue'
import E from 'wangeditor'
import { CircleCloseFilled } from '@element-plus/icons-vue'
const phoneEditor = ref('')
onMounted(() => {
  phoneEditor.value = new E('#richText')
  phoneEditor.value.zIndex.baseZIndex = 100
  phoneEditor.value.config.height = 600;
  phoneEditor.value.config.uploadImgShowBase64 = true
  phoneEditor.value.config.showLinkImg = false
  phoneEditor.value.create()
  phoneEditor.value.txt.html()
})
const tableL= reactive({view:"",drawer:false})
const getHowView = () => {
  tableL.drawer=true;
  tableL.view = phoneEditor.value.txt.html()
}
const form = new reactive({})

</script>
<style lang="scss">

.el-main {
  .richText_main {
    width: 100%;

    .text {
      width: 100%;
      height: 240px;
    }

    .richText_c {
      width: 100%;
    }
  }

  .richText_button {
    margin-top: 5px;
    height: 50px;
  }
}
/**/
</style>