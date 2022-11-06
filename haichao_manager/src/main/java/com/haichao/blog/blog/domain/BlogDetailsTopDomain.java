package com.haichao.blog.blog.domain;
import com.haichao.blog.blog.entity.vo.BlogDetailsVO;
import com.haichao.blog.blog.mapper.BlogDetailsTopMapper;
import com.haichao.blog.blog.entity.vo.BlogDetailsTopVO;
import com.haichao.result.BaseJsonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
@Service
public class BlogDetailsTopDomain{
        @Autowired
        private  BlogDetailsTopMapper BlogDetailsTopMapper;
        public List<BlogDetailsVO> findList(Map<String, Object> findParam) {
                return BlogDetailsTopMapper.findList(findParam);
        }
        public BlogDetailsTopVO findById(String cguid) {
                return BlogDetailsTopMapper.findById(cguid);
        }
        public BaseJsonVo deleteById(String cguid) {
                BlogDetailsTopMapper.deleteById(cguid);
                return new BaseJsonVo();
        }
        public BaseJsonVo add(BlogDetailsTopVO entity) {
                BlogDetailsTopMapper.add(entity);
                return new BaseJsonVo();
        }
        public BaseJsonVo update(BlogDetailsTopVO entity) {
                BlogDetailsTopMapper.update(entity);
                return new BaseJsonVo();
        }
}
