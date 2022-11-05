<template>
  <div class="el-main">
    <div class="main_my">
      <div class="main_image">
        <el-carousel>
          <el-carousel-item v-for="item in swiperList" :key="item.id">
            <img src="@/assets/1.jpg" alt="">
          </el-carousel-item>
        </el-carousel>
      </div>
      <div class="div_1"></div>

    </div>
    <div>
      <div class="main_conten"></div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      swiperList: [
        {
          id: 0,
          imgUrl: '/your_blog/src'
        }, {
          id: 1,
          imgUrl: 'http://v.bootstrapmb.com/2018/11/yabhk2948/img/img2.jpg'
        }, {
          id: 2,
          imgUrl: 'http://v.bootstrapmb.com/2018/11/yabhk2948/img/img3.jpg'
        }
      ], //轮播图数据
      dayData: new Date(), //日历
      scroll: 0, //页面滚动距离
    }
  }
}
</script>

<style lang="scss" scoped>
.el-main {
  padding-top: 10px;
  padding-left: 5px;
  padding-right: 5px;
  .main_my {
    position: relative;
    width: 100%;
    height: 300px;

    .main_image {
      float: left;
      width: 70%;
      height: 100px;

      .el-carousel {
        width: 100%;
        height: 300px;

        img {
          width: auto;
          height: 100%;
          width: 100%;
          max-height: 100%;
          border-radius: 4px;
          -webkit-border-radius: 4px;
          -moz-border-radius: 4px;
        }
      }
    }

    .div_1 {
      float: right;
      width: 30%;
      height: 100%;
      background: #48e4ff;
    }
  }
  .main_conten{
    height: 1800px;
    width: 100%;
    background: #ff4d00
  }
}

/*.el-main{
  .el-carousel{
    width:60%;
    height: 310px;
    img{
      width:100%;
      height:100%;
      border-radius: 10px;
    }

  }
  .riggg{
    background-color: #ff4d00;
    width: 30%;
    height:100%;
    float: right;
    top:0px
  }
}*/
</style>