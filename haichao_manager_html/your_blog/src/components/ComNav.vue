<template>
    <div class="nav-bg ">
        <p class="sign">你自己的boke</p>
        <div class="nav-box fl-bt" :class="scroll>90? 'fixed-nav':''">
            <div class="lf">
                <div class="uinfo">
                    <img class="up-head" src="../assets/3.jpg" alt="">
                    <h3 class="up-name">MoGen</h3>
                </div>
                <ul class="menu-list">
                    <li :class="$route.path==item.navPath?'on-nav':''" 
                    v-for="item in navList" :key="item.id" @click="navTo(item.navPath)">
                        {{item.navName}}
                    </li>
                </ul>
            </div>
            <div class="login" @click="$store.state.hasImpower?'':login()">
                {{$store.state.hasImpower?"已授权":"授权"}}
            </div>
        </div>
        
    </div>
</template>

<script>
export default {
    data(){
        return {
            navList:[
                {
                    id:0,
                    navName:'首页',
                    navPath:'/'
                },
                {
                    id:1,
                    navName:'友链',
                    navPath:'/friends'
                },
                {
                    id:2,
                    navName:'分类',
                    navPath:'/classify'
                },
                {
                    id:3,
                    navName:'写文章',
                    navPath:'/write'
                }
            ],
            hasImpower:false,  //是否授权
            scroll:0
        }
    },
    methods:{
        navTo(path){
            if(path!==this.$route.path){
                this.$router.push({
                    path
                })
            }
        },
        login(){
            console.log(2);
            this.$router.push({
                path:'/login'
            })
        },
        // 滚动事件
        scrollEvent(){
            this.scroll = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop;
        }
    },
    mounted(){
        window.addEventListener('scroll', this.scrollEvent)
    },
    computed:{
        getImpower(){
            if(localStorage.getItem('hasImpower')){
                this.$store.state.hasImpower=localStorage.getItem('hasImpower');
                this.$store.state.uinfo=JSON.parse(localStorage.getItem("blogsuinfo"));
            };
            return this.$store.state.hasImpower;
        }
    },
    watch:{
        getImpower(newval){
            this.hasImpower=newval
        }
    }
}
</script>

<style scoped>

    .fl-bt{
        display: flex;
        justify-content: space-between;
    }
    .nav-bg{
        position: relative;
        height: 150px;
        background: url('../assets/nav-bg.jpg') no-repeat;
        background-size: cover;
        color: #f7f7f7;
        font-size: 14px;
        line-height: 60px;
    }
    .nav-bg .sign{
        width: 600px;
        padding: 20px 0 0 160px;
        font-family: "楷体","楷体_GB2312";
        font-size: 16px;
        color: rgba(255,255,255,.8);
        font-weight: 100;
        text-align: left;
        line-height: 25px;
    }
    .nav-box{
        position: absolute;
        bottom: 0;
        left: 0;
        width: 100%;
        min-width: 1100px;
        height: 60px;
        background-color: rgba(0,0,0,.5);
        padding: 0 10%;
    }
    .nav-box .lf{
        display: flex;
    }
    .uinfo{
        display: flex;
    }
    .up-head{
        width: 40px;
        height: 40px;
        border-radius: 100%;
        margin-top: 10px;
        object-fit: cover;
    }
    .up-name{
    padding: 0 50px 0 10px;
    }
    .menu-list{
        display: flex;
    }
    .menu-list li{
        padding: 0 30px;
        height: 100%;
        cursor: pointer;
    }
    .menu-list .on-nav{
        background-color: rgba(255,255,255,.2);
    }
    .login{
        cursor: pointer;
    }
    .fixed-nav{
        position: fixed;
        top: 0;
        left: 0;
        z-index: 999;
        background-color: #333;
    }
</style>