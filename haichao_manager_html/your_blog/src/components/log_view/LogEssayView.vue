<template>
  <div class="el-main">
    <el-row class="mb-4">
      <el-button type="info" @click="showUpdate(blog.data.cguid)">修改</el-button>
    </el-row>

    <el-input v-model="blog.data.name"></el-input>
    <div v-html="blog.data.details"></div>
  </div>
</template>

<script setup>
import { onMounted, reactive} from "vue";
import {useRoute,useRouter } from 'vue-router';
import {findLogByid} from "@/components/util/request";
const blog = new reactive({data:{}});
const route = useRoute();
const router = useRouter()


onMounted(() => {
  findById(route.params.id);
})
const findById= (id) =>{
  findLogByid({cguid:id}).then(function (response) {
    blog.data=response;
    console.log(blog);
  }).catch(function (error) {
    console.log(error);
  }).finally(function () {
    // 总是会执行
  });
}

const showUpdate= (id) =>{
  router.push({name:"文章操作",params: {id :cguid}})
}
</script>

<style lang="scss" scoped>
</style>