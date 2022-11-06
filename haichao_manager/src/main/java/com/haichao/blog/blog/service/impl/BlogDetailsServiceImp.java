package com.haichao.blog.blog.service.impl;
import com.haichao.blog.blog.service.BlogDetailsService;
import com.haichao.blog.blog.entity.vo.BlogDetailsVO;
import com.haichao.blog.blog.domain.BlogDetailsDomain;
import com.haichao.result.BaseJsonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
@Service
public class BlogDetailsServiceImp implements BlogDetailsService{
        @Autowired
        private  BlogDetailsDomain blogDetailsDomain;
        @Override
        public List<BlogDetailsVO> findList(Map<String, Object> findParam) {
                return blogDetailsDomain.findList(findParam);
        }

        @Override
        public List<BlogDetailsVO> findTopList() {
                return blogDetailsDomain.findTopList();
        }

        @Override
        public BlogDetailsVO findById(String cguid) {
                return blogDetailsDomain.findById(cguid);
        }
        @Override
        public BaseJsonVo deleteById(String cguid) {
                return blogDetailsDomain.deleteById(cguid);
        }
        @Override
        public BaseJsonVo add(BlogDetailsVO entity) {
                return  blogDetailsDomain.add(entity);
        }
        @Override
        public BaseJsonVo update(BlogDetailsVO entity) {
                return blogDetailsDomain.update(entity);
        }

        @Override
        public BaseJsonVo audit(String id) {
                return blogDetailsDomain.audit(id);
        }

        @Override
        public BaseJsonVo unAudit(String id) {
                return blogDetailsDomain.unAudit(id);
        }
}
