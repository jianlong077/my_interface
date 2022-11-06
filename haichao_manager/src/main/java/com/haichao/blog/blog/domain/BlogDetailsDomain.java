package com.haichao.blog.blog.domain;
import com.haichao.annotations.idorcode.code.InCode;
import com.haichao.annotations.idorcode.id.InId;
import com.haichao.annotations.param.Body;
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
        private  BlogDetailsMapper blogDetailsMapper;
        public List<BlogDetailsVO> findList(Map<String, Object> findParam) {
                return blogDetailsMapper.findList(findParam);
        }

        public List<BlogDetailsVO> findTopList() {
                return blogDetailsMapper.findTopList();
        }
        public BlogDetailsVO findById(String cguid) {
                return blogDetailsMapper.findById(cguid);
        }
        public BaseJsonVo deleteById(String cguid) {
                blogDetailsMapper.deleteById(cguid);
                return new BaseJsonVo();
        }
        @InId(id="cguid")
        public BaseJsonVo add(@Body BlogDetailsVO entity) {
                blogDetailsMapper.add(entity);
                return new BaseJsonVo();
        }
        public BaseJsonVo update(BlogDetailsVO entity) {
                blogDetailsMapper.update(entity);
                return new BaseJsonVo();
        }

        public BaseJsonVo audit(String id) {
                blogDetailsMapper.audit(id);
                return new BaseJsonVo();
        }

        public BaseJsonVo unAudit(String id) {
                blogDetailsMapper.unAudit(id);
                return new BaseJsonVo();
        }
}
