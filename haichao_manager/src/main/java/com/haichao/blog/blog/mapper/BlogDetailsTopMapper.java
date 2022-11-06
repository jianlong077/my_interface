package com.haichao.blog.blog.mapper;
import com.haichao.blog.blog.entity.vo.BlogDetailsTopVO;
import com.haichao.blog.blog.entity.vo.BlogDetailsVO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author baomidou
 * @since 2022-02-18
 */
@Mapper
public interface BlogDetailsTopMapper{
        List<BlogDetailsVO> findList(Map<String, Object> findParam) ;
        BlogDetailsTopVO findById(@Param("cguid")String cguid) ;
        int deleteById(@Param("cguid")String cguid) ;
        int add(BlogDetailsTopVO entity) ;
        int update(BlogDetailsTopVO entity) ;
}