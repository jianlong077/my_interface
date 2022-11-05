package com.haichao.blog.blog.service;
import com.haichao.blog.blog.entity.vo.BlogDetailsVO;
import com.haichao.result.BaseJsonVo;
import java.util.List;
import java.util.Map;
public interface  BlogDetailsService{
        List<BlogDetailsVO> findList(Map<String, Object> findParam);
        /**
         * 根据ID查询
         */
        BlogDetailsVO findById(String cguid);
        /**
         * 根据ID删除
         */
        BaseJsonVo deleteById(String cguid);
        /**
         * 新增
         */
        BaseJsonVo add( BlogDetailsVO entity);
        /**
         *  更新
         */
        BaseJsonVo update(BlogDetailsVO entity);
}