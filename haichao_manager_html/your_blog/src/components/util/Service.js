
import axios from 'axios';
const baseURL1 = 'http://localhost:8081'


//创建请求实例
const Service=axios.create({
  timeout:8000,
  baseURL:baseURL1,
  headers:{
  "Content-Type":"application/json;charset:utf-8"
  }
})
//请求拦截
Service.interceptors.request.use(config=>{
  console.log(config)
  return config;
})
//相应拦截
Service.interceptors.response.use(response=>{
console.log(response)
  return response.data;
},err=>{
  console.log(err)
})

export const post=config=>{
  return Service({
    ...config,
    method:"post",
    data:config.data
  })
}

export const get=config=>{
  return Service({
    ...config,
    method:"get",
    params:config.data
  })
}