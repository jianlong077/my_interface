<template>
  <comNavComp></comNavComp>
  <div class="container">
    <div class="search wrap">
      <input type="text" placeholder="search...">
      <a href="#"> <Search style="width: 1em; height: 1em; margin-right: 3px;margin-top: 5px;" /></a>
    </div>
    <div class="swiper wrap">
      <!-- 轮播图 -->
      <el-carousel :interval="4000" height="500px" indicator-position="none">
        <el-carousel-item v-for="item in swiperList" :key="item.id">
          <img :src="item.imgUrl" alt="">
        </el-carousel-item>
      </el-carousel>
      <!-- 日历 -->
      <div class="day-box">
        <el-calendar v-model="dayData" height="0px">
        </el-calendar>
      </div>
      <!-- 右侧固定内容 -->
      <fixedRtcontComp></fixedRtcontComp>
    </div>
    <div class="about-article wrap">
      <div class="item"  >
        <div class="bookmark">
          <blogLabelComp></blogLabelComp>
        </div>
        <h2 ><a href="" @click="toDetail">uni-app 类似轮播拖拽效果日日日</a></h2>
        <p class="describe">uni-app 类似轮播拖拽效果,但不是轮播 uni-app 类似轮播拖拽效果,</p>
      </div>
      <div class="item" v-for="item in 3" :key="item" >
        <div class="bookmark">
          <blogLabelComp></blogLabelComp>
        </div>
        <h2>uni-app 类似轮播拖拽效果</h2>
        <img src="../assets/article-img.png" alt="">
        <p class="describe">uni-app 类似轮播拖拽效果,但不是轮播 uni-app 类似轮播拖拽效果,
          但不是轮播uni-app 类似轮播拖拽效果,但不是轮播uni-app 类似轮播拖拽效果,
          但不是轮播uni-app 类似轮播拖拽效果,但不是轮播uni-app 类似轮播拖拽效果,但不是轮播</p>
        <div class="read" @click="toDetail"><span>READ</span></div>
      </div>
      <div class="page">
        <el-pagination
            :hide-on-single-page="false"
            :total="5"
            :page-size="2"
            layout="prev, pager, next">
        </el-pagination>
      </div>
    </div>

    <footerComp></footerComp>
  </div>
</template>

<script>
import footerComp from '@/components/Footer.vue'
import fixedRtcontComp from '@/components/FixedRtcont.vue'
import blogLabelComp from'@/components/BlogLabel.vue'
import comNavComp from '@/components/ComNav.vue'
export default {
  components:{
    footerComp ,
    fixedRtcontComp ,
    blogLabelComp ,
    comNavComp
  },
  data () {
    return {
      swiperList:[
        {
          id:0,
          imgUrl:'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fwww.gpbctv.com%2Fuploads%2F20210424%2Fzip_1619246266UkP6CL.jpg&refer=http%3A%2F%2Fwww.gpbctv.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1669561022&t=15b106a75084e8765e3930f11d198433'
        },{
          id:1,
          imgUrl:'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.daimg.com%2Fuploads%2Fallimg%2F210114%2F1-210114151951.jpg&refer=http%3A%2F%2Fimg.daimg.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1669561022&t=3b7627b3e83a5548e4c01f3bb9e3851d'
        },{
          id:2,
          imgUrl:'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Flmg.jj20.com%2Fup%2Fallimg%2F1114%2F042421133312%2F210424133312-1-1200.jpg&refer=http%3A%2F%2Flmg.jj20.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1669561022&t=5456555e0ceb535c9cf137fced91fe1b'
        }
      ], //轮播图数据
      dayData:new Date(), //日历
      scroll:0, //页面滚动距离
    }
  },
  methods:{
    //跳转详情页
    toDetail(){
      this.$router.push({
        path:'/detail'
      })
    },

  },
  mounted(){
  }
}
</script>
<style  lang="scss">
a {text-decoration: none;}
.container{
  min-width: 1460px;
}
.fl-jb{
  display: flex;
  justify-content: space-between;
}
.wrap{
  width: 900px;
  margin: 0 auto;
}
.search{
  display: flex;
  margin-top: 60px;
  justify-content: right;
  font-size: 20px;
}
.search i{
  display: block;
  margin: 5px 0 0 10px;
}
.search input{
  width: 400px;
  height: 30px;
  border: none;
  border-bottom: 1px solid #999;
  padding-left: 30px;
  background-color: #f3f5f7;
  outline: none;
  font-size: 16px;
}
/* 轮播图样式 */
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}
.swiper{
  width: 900px;
  position: relative;
  margin-top: 20px;
}
.swiper img{
  width: 100%;
}
/* 日历 */
.day-box{
  position: absolute;
  left: -310px;
  top: 0;
  width: 300px;
  font-size: 12px;
}
.el-calendar-day{
height: 30px!important;
}

/* 文章概括 */
.about-article > div{
  position: relative;
  background-color: #fff;
  margin-top: 30px;
  padding-bottom: 40px;
}
.bookmark{
  position: absolute;
  top: 50px;
  left: -18px;
}
.about-article > div:hover{
  box-shadow: 0 0 10px #ccc;
}
.about-article h2{
  padding: 20px;
  font-weight: 400;
  margin-bottom: 20px;
}
.about-article .describe{
  display: -webkit-box;
  width: 100%;
  margin-top: 20px;
  padding: 0 30px;
  overflow: hidden;
  -webkit-line-clamp: 2;
  text-overflow: ellipsis;
  -webkit-box-orient: vertical;
  text-align: left;
  text-indent: 2em;
  line-height: 25px;
}
/* 阅读更多按钮 */
.read{
  position: relative;
  width: 50px;
  height: 50px;
  transform: rotate(45deg);
  background-color: #f0f5fb;
  margin: 0 auto;
  margin-top: 50px;
  cursor: pointer;
  font-size: 12px;
  line-height: 50px;
}
.read span{
  display: block;
  transform: rotate(-45deg);
}
.read::after{
  position: absolute;
  top: -4px;
  left: -2px;
  display: block;
  content: '';
  width: 50px;
  height: 50px;
  border: 3px solid #478591;
  border-radius: 3px;
  transform: rotate(-45deg);
  transition: all .3s;
}
.read:hover{
  color: #478591;
}
.read:hover::after{
  transform: rotate(0deg);
}
.page{
 height: 30px;

}
.page .el-pagination{
  float: right;
  text-align: center;
}
.page ::v-deep .el-pager li.active,
.page ::v-deep .el-pager li:hover{
  color: #65b0bf;
}
</style>
