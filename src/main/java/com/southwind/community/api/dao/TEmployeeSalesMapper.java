package com.southwind.community.api.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.southwind.community.api.pojo.Criteria;
import com.southwind.community.api.pojo.TEmployeeSales;

public interface TEmployeeSalesMapper {
    /**
     * 根据条件查询记录总数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    int deleteByExample(Criteria example);

    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer esId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(TEmployeeSales record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(TEmployeeSales record);

    /**
     * 根据条件查询记录集
     */
    List<TEmployeeSales> selectByExample(Criteria example);

    /**
     * 根据主键查询记录
     */
    TEmployeeSales selectByPrimaryKey(Integer esId);

    /**
     * 根据条件更新属性不为空的记录
     */
    int updateByExampleSelective(@Param("record") TEmployeeSales record, @Param("example") Criteria example);

    /**
     * 根据条件更新记录
     */
    int updateByExample(@Param("record") TEmployeeSales record, @Param("example") Criteria example);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(TEmployeeSales record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(TEmployeeSales record);
}