package com.haichao.blog.blog.entity.vo;
import java.io.Serializable;
import com.haichao.blog.blog.entity.BlogDetailsTop;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * 更新时间 2020-05-08 16:51:11
 * 表 t_oms_shop_split
*/
public class BlogDetailsTopVO extends BlogDetailsTop implements Serializable{
    public BlogDetailsTop copy(){
        BlogDetailsTop  toObj=new BlogDetailsTop();
            BeanUtils.copyProperties( this,toObj);
        return toObj;
    }
    public BlogDetailsTopVO(BlogDetailsTop  fromObj) {
        BeanUtils.copyProperties( fromObj,this);
    }
    public BlogDetailsTopVO(){}
}