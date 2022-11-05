<template>
  <div class="aside-Left-box">
    <div class="aside-Left-box-1">
      <div class="aside-Left-box-1-1"><span>标签</span></div>
      <div class="aside-Left-box-1-2">
        <div class="aside-Left-box-1-2-1" v-for='index in 40' :key='index'><span>标签-{{index}}</span></div>

        <div class="aside-Left-box-1-2-1">dsdf</div>
        <div class="aside-Left-box-1-2-1">dsdf</div>



        <div class="clear"></div>
      </div>
    </div>
  </div>
</template>

<script setup>
</script>

<style scoped lang="scss">
.aside-Left-box{
  float: left;
  width: 70%;
  .aside-Left-box-1{
    width: 100%;
    .aside-Left-box-1-1{
      padding-top: 5px;
      width: 100%;
      height:35px;
      background-image: url("@/assets/首部标签.png");
      background-size: 100% 100%;

    }
    .aside-Left-box-1-2{
      width: 100%;
      min-height:180px;
      .aside-Left-box-1-2-1{
        float: left;
        cursor: pointer;
        padding: 2px 2px 1px;
        margin: 3px;
        display: inline-block;
        border-radius: 0px;
        border: 0.1em solid #050505;
        background-color: #FFFFFF;
        span{
          color: #2C3E50;
        }


      }
      .clear{ clear:both}
      .aside-Left-box-1-2-1:hover {
        -webkit-box-shadow: #ccc 5px 5px 5px;
        -moz-box-shadow: #ccc 5px 5px 5px;
        box-shadow: #ccc 5px 5px 5px;
        span{
          color: #CCCCD8;
        }
      }
    }
  }
}
</style>