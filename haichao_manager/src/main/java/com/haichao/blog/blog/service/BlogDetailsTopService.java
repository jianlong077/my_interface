package com.haichao.blog.blog.service;
import com.haichao.blog.blog.entity.vo.BlogDetailsTopVO;
import com.haichao.blog.blog.entity.vo.BlogDetailsVO;
import com.haichao.result.BaseJsonVo;
import java.util.List;
import java.util.Map;
public interface  BlogDetailsTopService{
        List<BlogDetailsVO> findList(Map<String, Object> findParam);
}