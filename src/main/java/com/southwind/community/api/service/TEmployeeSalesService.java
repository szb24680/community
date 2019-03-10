package com.southwind.community.api.service;

import java.util.List;

import com.southwind.community.api.pojo.Criteria;
import com.southwind.community.api.pojo.TEmployeeSales;

public interface TEmployeeSalesService {
    int countByExample(Criteria example);

    TEmployeeSales selectByPrimaryKey(Integer esId);

    List<TEmployeeSales> selectByExample(Criteria example);

    int deleteByPrimaryKey(Integer esId);

    int updateByPrimaryKeySelective(TEmployeeSales record);

    int updateByPrimaryKey(TEmployeeSales record);

    int deleteByExample(Criteria example);

    int updateByExampleSelective(TEmployeeSales record, Criteria example);

    int updateByExample(TEmployeeSales record, Criteria example);

    int insert(TEmployeeSales record);

    int insertSelective(TEmployeeSales record);
}