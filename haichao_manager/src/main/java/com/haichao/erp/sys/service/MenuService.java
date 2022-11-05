package com.haichao.erp.sys.service;
import com.haichao.erp.sys.entity.vo.MenuVO;
import com.haichao.result.BaseJsonVo;
import java.util.List;
import java.util.Map;
public interface  MenuService{
        List<MenuVO> findList(Map<String, Object> findParam);
        /**
         * 根据ID查询
         */
        MenuVO findById(String cguid);
        /**
         * 根据ID删除
         */
        BaseJsonVo deleteById(String cguid);
        /**
         * 新增
         */
        BaseJsonVo add( MenuVO entity);
        /**
         *  更新
         */
        BaseJsonVo update(MenuVO entity);
}