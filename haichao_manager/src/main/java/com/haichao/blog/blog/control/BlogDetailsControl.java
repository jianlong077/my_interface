package com.haichao.blog.blog.control;

import com.haichao.blog.blog.entity.vo.BlogDetailsTopVO;
import com.haichao.blog.blog.service.BlogDetailsService;
import com.haichao.blog.blog.entity.vo.BlogDetailsVO;
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
public class BlogDetailsControl{
        @Autowired
        private  BlogDetailsService  blogDetailsService;
        /**
        * 查询List
        */
        @PostMapping(value = "/blog/blog/blogDetails/findList")
        @Permission(nameApi = "", codeApi = "")
        public Object findList(HttpServletRequest request,@RequestBody PageFindParam<BlogDetailsVO> pageFindParam){
                if(pageFindParam.getPageNum()!=0&&pageFindParam.getPageSize()!=0){
                    PageHelper.startPage(pageFindParam.getPageNum(),pageFindParam.getPageSize());
                    List<BlogDetailsVO> list=blogDetailsService.findList(pageFindParam.getFindParams());
                    return new PageFind(list);
                }else{
                     List<BlogDetailsVO> list=blogDetailsService.findList(pageFindParam.getFindParams());
                return list;
                }
        }
        @GetMapping(value = "/blog/blog/blogDetails/findTopList")
        public Object findTopList(HttpServletRequest request){
                List<BlogDetailsVO> list=blogDetailsService.findTopList();
                return list;
        }
        /**
         * 根据ID查询
         */
        @GetMapping(value = "/blog/blog/blogDetails/findById")
        public BlogDetailsVO findById(HttpServletRequest request,@RequestParam("cguid")String cguid){
                return blogDetailsService.findById(cguid);
        }
        /**
         * 根据ID删除
         */
        @GetMapping(value = "/blog/blog/blogDetails/deleteById")
        public BaseJsonVo deleteById(HttpServletRequest request,@RequestParam("cguid")String cguid){
                return blogDetailsService.deleteById(cguid);
         }
        /**
         * 新增
         */
        @PostMapping(value = "/blog/blog/blogDetails/add")
        public BaseJsonVo add(HttpServletRequest request,@RequestBody BlogDetailsVO entity){
                return blogDetailsService.add(entity);
        }

        /**
         *  更新
         */
        @PostMapping(value = "/blog/blog/blogDetails/update")
        public BaseJsonVo update(HttpServletRequest request,@RequestBody BlogDetailsVO entity){
                entity.setStatus(1);
                return blogDetailsService.add(entity);
        }
        @GetMapping(value = "/blog/blog/blogDetails/audit")
        public BaseJsonVo audit(HttpServletRequest request,@RequestParam("id") String  id){
                return blogDetailsService.audit(id);
        }
        @GetMapping(value = "/blog/blog/blogDetails/unAudit")
        public BaseJsonVo unAudit(HttpServletRequest request,@RequestParam("id") String  id){
                return blogDetailsService.unAudit(id);
        }
}