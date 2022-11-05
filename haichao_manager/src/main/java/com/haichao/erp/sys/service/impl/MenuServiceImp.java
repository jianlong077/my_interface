package com.haichao.erp.sys.service.impl;
import com.haichao.erp.sys.service.MenuService;
import com.haichao.erp.sys.entity.vo.MenuVO;
import com.haichao.erp.sys.domain.MenuDomain;
import com.haichao.result.BaseJsonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
@Service
public class MenuServiceImp implements MenuService{
        @Autowired
        private  MenuDomain menuDomain;
        @Override
        public List<MenuVO> findList(Map<String, Object> findParam) {
                return menuDomain.findList(findParam);
        }
        @Override
        public MenuVO findById(String cguid) {
                return menuDomain.findById(cguid);
        }
        @Override
        public BaseJsonVo deleteById(String cguid) {
                return menuDomain.deleteById(cguid);
        }
        @Override
        public BaseJsonVo add(MenuVO entity) {
                return  menuDomain.add(entity);
        }
        @Override
        public BaseJsonVo update(MenuVO entity) {
                return menuDomain.update(entity);
        }
}
