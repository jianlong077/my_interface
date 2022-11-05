import {createRouter, createWebHistory} from 'vue-router'

const routes = [
    {
        path: '/',
        name: '主页',
       component: () => import('@/views/log_home.vue'),
        redirect: () => {
            return 'LogEssayListTop'//LogEssayListTop
        },
        children: [
            {
            path: '/LogEssayListTop',
            name: '置顶文章',
            component: () => import('@/components/log_view/LogEssayListTop.vue')
        },{
          path: '/LogEssayList',
          name: '文章列表',
          component: () => import('@/components/log_view/LogEssayList.vue'),
                children: [{
                    path: '/LogEssayView1',
                    name: '文章查看1',
                    component: () => import('@/components/log_view/LogEssayView.vue')
                }]
        },{
          path: '/LogEssayView',
          name: '文章查看',
          component: () => import('@/components/log_view/LogEssayView.vue')
        },{
          path: '/LogEssayWrite',
          name: '文章描写',
          component: () => import('@/components/log_view/LogEssayWrite.vue')
        }]
    }, {
        path: '/1',
        name: 'home1',
        component: () => import('@/views/HomeView.vue')
    }, {
        path: '/2',
        name: 'home2',
        component: () => import('@/components/BlogLabel.vue')
    }, {
        path: '/3',
        name: 'home3',
        component: () => import('@/components/other/BlogItem.vue')
    }, {
        path: '/LogAsideLeft',
        name: 'home3',
        component: () => import('@/components/log_home/LogAsideLeft.vue')
    },/*
  {
    path: '/write',
    name: 'write',
    component: ()=> import('@/views/HomeView.vue')
  },
  {
    path: '/detail',
    name: 'detail',
    component: ()=> import('@/views/HomeView.vue')
  },{
    path: '/friends',
    name: 'friends',
    component: ()=> import('@/views/HomeView.vue')
  },*/{
        path: '/login',
        name: 'login',
        component: () => import('@/views/Login.vue')
    }/*,{
    path: '/classify',
    name: 'classify',
    component: ()=> import('@/views/HomeView.vue')
  }*/
]

const router = createRouter({
    history: createWebHistory("/yourlog/"),
    routes
})

export default router
