<template>
  <div class="container">
    <div class="num-login">
        <img class="head" :src="$store.state.uinfo.head" alt="">
        <div class="name">{{$store.state.uinfo.name}}</div>
      <div>
        <input
          id="number"
          type="text"
          placeholder="输入qq获取头像及昵称"
          v-model="num"
        />
      </div>
      <button @click="getInfo">授权</button>
    </div>
    <div class="foot">
        <foot></foot>
    </div>
  </div>
</template>

<script>
import foot from '../components/Footer.vue'
export default {
    components:{
        foot
    },
    data(){
        return {
            num:'', //qq账号
            // uinfo:{
            //     head:'//q.qlogo.cn/g?b=qq&nk=1439075486&s=100',
            //     name:"http://r.pengyou.com/fcg-bin/cgi_get_portrait.fcg?uins=1439075486"
            // }
        }
    },
    methods:{
        getInfo(){
            if(this.num){
                this.$requst.getinfo(this.num).then(res=>{
                    let start = res.indexOf("[")
                    let end = res.indexOf("}")
                    let a = res.substring(start,end)
                    let result = JSON.parse(a);
                    this.$store.state.uinfo.head=`//q.qlogo.cn/g?b=qq&nk=${this.num}&s=100`;
                    this.$store.state.uinfo.name=result[6];
                    this.$store.state.hasImpower=true;
                    localStorage.setItem("hasImpower",true);
                    localStorage.setItem("blogsuinfo",JSON.stringify(this.$store.state.uinfo))
                    this.$router.replace({
                        path:'/'
                    })
                    console.log(result);
                })
            }
        }
    }
};
</script>

<style scoped>
.container{
    min-height: calc(100vh - 330px);
}
.num-login {
  margin-top: 130px;
}
.num-login input {
  height: 40px;
  width: 280px;
  margin-top: 20px;
  padding-left: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
}
.num-login button {
  width: 180px;
  height: 40px;
  margin-top: 30px;
  text-align: center;
  line-height: 40px;
  background-color: #966f7f;
  border: none;
  border-radius: 5px;
  color: #fff;
}
.num-login p {
  margin-top: 30px;
  color: #999;
  font-size: 12px;
}
.num-login p a {
  color: #478591;
}
.head{
    width: 60px;
    height: 60px;
    border-radius: 50%;
}
.foot{
    position: absolute;
    bottom: 0;
    left: 0;
    width: 100%;
}
</style>