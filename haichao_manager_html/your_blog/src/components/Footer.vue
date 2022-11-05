<template>
  <div class="footer">
    <div class="year">&copy;{{date.getFullYear()}}</div>
    <p>备案 / 许可证编号：川IPC备123456号</p>
    <p>制作本站已用: {{useTime}}</p>
  </div>
</template>

<script>
export default {
  data(){
    return {
      date:new Date(),
      startTime:1641787829,
      useTime:0
    }
  },
  methods:{
    //补零
    setDb(num){
      if (num < 10) {
        return '0' + num;
      } else {
        return '' + num;
      }
    },
    workTime(){
      setInterval(()=>{
        let spentTime=Date.parse(new Date())/1000-this.startTime;
        let sec=this.setDb(spentTime%60);
        let minus=this.setDb(Math.floor(spentTime / 60) % 60);
        let hour =this.setDb(Math.floor(spentTime / 360) % 24);
        let day = this.setDb(Math.floor(spentTime / 60 / 60 / 24));
        this.useTime = `${day}天 ${hour}小时 ${minus}分 ${sec}秒`;
      },1000)
    }
  },
  mounted(){
    this.workTime();
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.footer{
  background-color: #478591;
  margin-top: 50px;
  padding-bottom: 50px;
  color: #f5f5f5;
  font-size: 14px;
}
.year {
  padding: 20px 0;
}
.footer p{
  margin-bottom: 5px;
}
</style>
