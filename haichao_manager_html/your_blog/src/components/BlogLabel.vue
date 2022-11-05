<template>
  <div class="label-box">标签</div>
</template>

<script>
export default {

}
</script>

<style scoped>
    .label-box{
        height: 26px;
        padding: 0 20px 0 30px;
        background-color: #478591;
        border-radius: 0 3px 3px 0;
        color: #fff;
        font-size: 14px;
        line-height: 26px;
    }
    .label-box::after{
        position: absolute;
        bottom: -12px;
        left: 5px;
        display: block;
        content: '';
        height: 0;
        border: 12px solid #2f5860;
        border-color:  transparent transparent transparent #2f5860;
        transform: rotate(-45deg);
    }
</style>