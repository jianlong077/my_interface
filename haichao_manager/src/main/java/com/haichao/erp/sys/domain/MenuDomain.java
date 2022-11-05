package com.haichao.erp.sys.domain;
import com.haichao.erp.sys.mapper.MenuMapper;
import com.haichao.erp.sys.entity.vo.MenuVO;
import com.haichao.result.BaseJsonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
@Service
public class MenuDomain{
        @Autowired
        private  MenuMapper MenuMapper;
        public List<MenuVO> findList(Map<String, Object> findParam) {
                return MenuMapper.findList(findParam);
        }
        public MenuVO findById(String cguid) {
                return MenuMapper.findById(cguid);
        }
        public BaseJsonVo deleteById(String cguid) {
                MenuMapper.deleteById(cguid);
                return new BaseJsonVo();
        }
        public BaseJsonVo add(MenuVO entity) {
                MenuMapper.add(entity);
                return new BaseJsonVo();
        }
        public BaseJsonVo update(MenuVO entity) {
                MenuMapper.update(entity);
                return new BaseJsonVo();
        }
}
