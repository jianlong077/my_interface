package com.haichao.blog.blog.service.impl;
import com.haichao.blog.blog.entity.vo.BlogDetailsVO;
import com.haichao.blog.blog.service.BlogDetailsTopService;
import com.haichao.blog.blog.entity.vo.BlogDetailsTopVO;
import com.haichao.blog.blog.domain.BlogDetailsTopDomain;
import com.haichao.result.BaseJsonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
@Service
public class BlogDetailsTopServiceImp implements BlogDetailsTopService{
        @Autowired
        private  BlogDetailsTopDomain blogDetailsTopDomain;
        @Override
        public List<BlogDetailsVO> findList(Map<String, Object> findParam) {
                return blogDetailsTopDomain.findList(findParam);
        }
}
