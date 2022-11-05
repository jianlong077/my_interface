package com.haichao.blog.blog.domain;
import com.haichao.blog.blog.mapper.BlogDetailsMapper;
import com.haichao.blog.blog.entity.vo.BlogDetailsVO;
import com.haichao.result.BaseJsonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
@Service
public class BlogDetailsDomain{
        @Autowired
        private  BlogDetailsMapper BlogDetailsMapper;
        public List<BlogDetailsVO> findList(Map<String, Object> findParam) {
                return BlogDetailsMapper.findList(findParam);
        }
        public BlogDetailsVO findById(String cguid) {
                return BlogDetailsMapper.findById(cguid);
        }
        public BaseJsonVo deleteById(String cguid) {
                BlogDetailsMapper.deleteById(cguid);
                return new BaseJsonVo();
        }
        public BaseJsonVo add(BlogDetailsVO entity) {
                BlogDetailsMapper.add(entity);
                return new BaseJsonVo();
        }
        public BaseJsonVo update(BlogDetailsVO entity) {
                BlogDetailsMapper.update(entity);
                return new BaseJsonVo();
        }
}
