<template>
  <div class="rt-cont">
    <!-- 作者信息 -->
    <div class="author-info">
      <div class="uinfo">
        <img src="../assets/3.jpg" alt="" />
        <div class="name">MoGen</div>
      </div>
      <div class="about-uinfo">
        <div>文章 3</div>
        <div>评论 0</div>
        <div>标签 1</div>
      </div>
    </div>
    <!-- 专栏 -->
    <div class="article-menu">
      <h3 class="tit">TA的专栏</h3>
      <ul class="menu-list">
        <li class="fl-jb" v-for="item in 3" :key="item">
          <div class="lf fl-jb">
            <img src="../assets/nav-bg1.jpg" alt="" />
            <h4>vue</h4>
          </div>
          <span>1篇</span>
        </li>
      </ul>
    </div>
    <!-- 广告 -->
    <div class="advertising">
      <img class="adv-img" src="../assets/1.jpg" alt="" />
      <!-- <ul class="advertising-list">
              <li v-for="item in swiperList" :key="item.id">
                <img :src="item.img" alt="">
              </li>
            </ul> -->
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.fl-jb {
  display: flex;
  justify-content: space-between;
}
/* 右侧固定内容 */
.rt-cont {
  width: 260px;
  position: absolute;
  top: 0;
  right: -270px;
}
.rt-cont > div {
  background-color: #fff;
  margin-bottom: 20px;
}
.article-menu {
  padding: 20px;
  border-radius: 5px;
}
.article-menu h3 {
  border-bottom: 1px solid #999;
  padding-bottom: 10px;
  font-size: 16px;
  text-align: left;
  font-weight: 500;
}
.article-menu .lf img {
  width: 24px;
  height: 24px;
}
.menu-list li {
  margin-top: 20px;
  padding-left: 10px;
  cursor: pointer;
}
.lf h4 {
  font-weight: 400;
  margin-left: 10px;
  line-height: 25px;
  color: #666;
}
.menu-list li:hover h4{
  color: #5fd9f1;
}
.menu-list span {
  color: #999;
}
.adv-img {
  width: 260px;
  height: 130px;
}
/* 作者信息 */
.author-info {
  background: url("../assets/bg.jpg") no-repeat;
  background-size: cover;
  border-radius: 5px 5px 0 0;
  color: #fff;
}
.author-info .uinfo {
  width: 260px;
  padding: 60px 30px 10px;
}
.author-info img {
  width: 60px;
  height: 60px;
  border-radius: 50%;
  object-fit: cover;
  border: 3px solid rgba(255, 255, 255, 0.2);
}
.author-info .name {
  margin: 5px 0;
}
.about-uinfo {
  display: flex;
  justify-content: space-around;
  border-top: 1px solid #999;
  padding: 10px 0;
  font-size: 14px;
  color: #ccc;
}
</style>