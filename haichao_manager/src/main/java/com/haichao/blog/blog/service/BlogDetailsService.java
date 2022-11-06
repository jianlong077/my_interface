package com.haichao.blog.blog.service;
import com.haichao.annotations.permissions.Permission;
import com.haichao.blog.blog.entity.vo.BlogDetailsVO;
import com.haichao.result.BaseJsonVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
public interface  BlogDetailsService{
        List<BlogDetailsVO> findList(Map<String, Object> findParam);

        /**
         * 查找首页置顶的10篇文章
         * @return
         */
        List<BlogDetailsVO>findTopList();
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
        /**
         *  审核
         */
        BaseJsonVo audit( String  id);
        /**
         *  未审
         */
        BaseJsonVo unAudit( String  id);
}