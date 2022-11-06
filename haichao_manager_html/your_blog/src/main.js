import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import 'element-plus/theme-chalk/index.css'
import ElementPlus from 'element-plus'
import zhCn from 'element-plus/dist/locale/zh-cn.mjs'
import * as Elicons from "@element-plus/icons-vue";

const app = createApp(App);
for (const [key, component] of Object.entries(Elicons)) {
    app.component(key, component)
}
app.use(store).use(router).use(ElementPlus,{locale: zhCn,}).mount('#app')
