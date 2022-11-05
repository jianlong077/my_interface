package com.haichao.erp.sys.control;

import com.haichao.erp.sys.service.MenuService;
import com.haichao.erp.sys.entity.vo.MenuVO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.haichao.annotations.permissions.Permission;
import java.util.List;
import com.haichao.page.PageFind;
import com.haichao.page.PageFindParam;
import com.haichao.result.BaseJsonVo;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
@RestController
@CrossOrigin
public class MenuControl{
        @Autowired
        private  MenuService  menuService;
        /**
        * 查询List
        */
        @PostMapping(value = "/erp/sys/menu/findList")
        @Permission(nameApi = "", codeApi = "")
        public Object findList(HttpServletRequest request,@RequestBody PageFindParam<MenuVO> pageFindParam){
                if(pageFindParam.getPageNum()!=0&&pageFindParam.getPageSize()!=0){
                    PageHelper.startPage(pageFindParam.getPageNum(),pageFindParam.getPageSize());
                    List<MenuVO> list=menuService.findList(pageFindParam.getFindParams());
                    return new PageFind(list);
                }else{
                     List<MenuVO> list=menuService.findList(pageFindParam.getFindParams());
                return list;
                }
        }
        /**
         * 根据ID查询
         */
        @PostMapping(value = "/erp/sys/menu/findById")
        @Permission(nameApi = "", codeApi = "")
        public MenuVO findById(HttpServletRequest request,@RequestParam("cguid")String cguid){
                return menuService.findById(cguid);
        }
        /**
         * 根据ID删除
         */
        @PostMapping(value = "/erp/sys/menu/deleteById")
        @Permission(nameApi = "", codeApi = "")
        public BaseJsonVo deleteById(HttpServletRequest request,@RequestParam("cguid")String cguid){
                return menuService.deleteById(cguid);
         }
        /**
         * 新增
         */
        @PostMapping(value = "/erp/sys/menu/add")
        @Permission(nameApi = "", codeApi = "")
        public BaseJsonVo add(HttpServletRequest request,@RequestBody MenuVO entity){
                return menuService.add(entity);
        }

        /**
         *  更新
         */
        @PostMapping(value = "/erp/sys/menu/update")
        @Permission(nameApi = "", codeApi = "")
        public BaseJsonVo update(HttpServletRequest request,@RequestBody MenuVO entity){
                return menuService.add(entity);
        }
}