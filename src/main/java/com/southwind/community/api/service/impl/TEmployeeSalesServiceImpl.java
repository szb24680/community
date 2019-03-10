package com.southwind.community.api.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.southwind.community.api.dao.TEmployeeSalesMapper;
import com.southwind.community.api.pojo.Criteria;
import com.southwind.community.api.pojo.TEmployeeSales;
import com.southwind.community.api.service.TEmployeeSalesService;

@Service
public class TEmployeeSalesServiceImpl implements TEmployeeSalesService {
    @Autowired
    private TEmployeeSalesMapper tEmployeeSalesMapper;

    private static final Logger logger = LoggerFactory.getLogger(TEmployeeSalesServiceImpl.class);

    public int countByExample(Criteria example) {
        int count = this.tEmployeeSalesMapper.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public TEmployeeSales selectByPrimaryKey(Integer esId) {
        return this.tEmployeeSalesMapper.selectByPrimaryKey(esId);
    }

    public List<TEmployeeSales> selectByExample(Criteria example) {
        return this.tEmployeeSalesMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer esId) {
        return this.tEmployeeSalesMapper.deleteByPrimaryKey(esId);
    }

    public int updateByPrimaryKeySelective(TEmployeeSales record) {
        return this.tEmployeeSalesMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(TEmployeeSales record) {
        return this.tEmployeeSalesMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(Criteria example) {
        return this.tEmployeeSalesMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(TEmployeeSales record, Criteria example) {
        return this.tEmployeeSalesMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(TEmployeeSales record, Criteria example) {
        return this.tEmployeeSalesMapper.updateByExample(record, example);
    }

    public int insert(TEmployeeSales record) {
        return this.tEmployeeSalesMapper.insert(record);
    }

    public int insertSelective(TEmployeeSales record) {
        return this.tEmployeeSalesMapper.insertSelective(record);
    }
}