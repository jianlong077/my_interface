import {post,get} from "@/components/util/Service.js"
//导出轮训图片
/*export const findlogPho=({})=>{
  return  get({url:"",})
}*/
//导出 图片右侧内容(描述)
/*export const findLogDescription=({})=>{
  return  get({url:""})
}*/
//导出置顶文章列表
export const findLogTop=data=>{
  return  get({url:"blog/blog/blogDetails/findTopList"})
}
//导出热门文章
export const findLogHot=({})=>{
  return  get({url:"blog/blog/blogDetails/findTopList"})
}

//导出最新评论
/*export const findLogComment=({})=>{
  return  get({url:""})
}*/

//导出所有标签
export const findLogTag=({})=>{
  return  get({url:""})
}
//文章新增
export const logAdd=(data)=>{
  return  post({url:"blog/blog/blogDetails/add",data:data})
}
//文章更新
export const logUpdate=(data)=>{
  return  post({url:"blog/blog/blogDetails/update",data:data})
}
//文章查询根据id
export const findLogByid=(data)=>{
  return  get({url:"blog/blog/blogDetails/findById",data:data})
}