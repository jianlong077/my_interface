package com.haichao.erp.sys.entity.vo;
import java.io.Serializable;
import com.haichao.erp.sys.entity.Menu;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * 更新时间 2020-05-08 16:51:11
 * 表 t_oms_shop_split
*/
public class MenuVO extends Menu implements Serializable{
    public Menu copy(){
        Menu  toObj=new Menu();
            BeanUtils.copyProperties( this,toObj);
        return toObj;
    }
    public MenuVO(Menu  fromObj) {
        BeanUtils.copyProperties( fromObj,this);
    }
    public MenuVO(){}
}