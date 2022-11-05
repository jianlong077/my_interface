package com.haichao.erp.sys.mapper;
import com.haichao.erp.sys.entity.vo.MenuVO;
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
public interface MenuMapper{
        List<MenuVO> findList(Map<String, Object> findParam) ;
        MenuVO findById(@Param("cguid")String cguid) ;
        int deleteById(@Param("cguid")String cguid) ;
        int add(MenuVO entity) ;
        int update(MenuVO entity) ;
}