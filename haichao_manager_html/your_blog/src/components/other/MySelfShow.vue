<template>
  <div class="myself-box">
    <div class="myself-box-1">
      <div class="myself-box-2"><img src="@/assets/1.jpg"></div>
      <div class="myself-box-3">
        <div>lihaichao</div>
      </div>
      <div class="myself-box-4">
        <div><span>文章:100</span></div>
        <div><span>评论:100</span></div>
        <div><span>标签:100</span></div>
      </div>
    </div>
  </div>
</template>

<script>
</script>

<style lang="scss" scoped>
.myself-box {
  width: 70%;
  height: 250px;
  padding-top: 10px;
  padding-bottom: 5px;
  border-right-width: 5px;


  .myself-box-1 {
    background-image: url("@/assets/bg.jpg");
    background-size: 100% 100%;
    border-radius: 6px;
    height: 100%;
    position: relative;

    .myself-box-2 {
      position: absolute;
      margin-top: 10%;
      margin-left: 25%;
      height: 50%;
      width: 50%;
      border-radius: 60%;
      background-color: #ff4d00;
      img{
        width:auto;
        height:100%;
        max-width:100%;
        max-height:100%;
        border-radius: 60px;
        -webkit-border-radius: 60px;
        -moz-border-radius: 60px;
      }
    }

    .myself-box-3 {
      bottom: 24%;
      position: absolute;
      width: 100%;
      height: 15%;
      border-radius: 10%;

      div {
        width: 50%;
        border-radius: 6px;
        margin-top: 4%;
        height: 90%;
        text-align: center;
        display: inline-block;
        margin-right: 5px;
        padding-top: 1%;
        font-size: 25px;
        color: #fff
      }
    }

    .myself-box-4 {
      border-top: 2px dashed #ffffff;
      position: absolute;
      bottom: 0px;
      height: 20%;
      width: 100%;
      div {
        width: 30%;
        border-radius: 6px;
        margin-top: 3%;
        height: 60%;
        text-align: center;
        display: inline-block;
        margin-left: 2px;
        padding-top: 1.2%;
        color: #fff;
      }
    }
  }
}
</style>