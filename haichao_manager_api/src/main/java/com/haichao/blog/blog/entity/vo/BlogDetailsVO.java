package com.haichao.blog.blog.entity.vo;
import com.haichao.blog.blog.entity.BlogDetails;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * 更新时间 2020-05-08 16:51:11
 * 表 t_oms_shop_split
*/
public class BlogDetailsVO extends BlogDetails implements Serializable{
    public BlogDetails copy(){
        BlogDetails  toObj=new BlogDetails();
            BeanUtils.copyProperties( this,toObj);
        return toObj;
    }
    public BlogDetailsVO(BlogDetails  fromObj) {
        BeanUtils.copyProperties( fromObj,this);
    }
    public BlogDetailsVO(){}
}