package com.southwind.community.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.southwind.community.api.pojo.Criteria;
import com.southwind.community.api.pojo.TEmployeeSales;
import com.southwind.community.api.service.TEmployeeSalesService;

import io.swagger.annotations.ApiOperation;

@RestController
public class EmployeeSalesController extends BaseController {

	@Resource
	TEmployeeSalesService employeeSalesService;

	@ApiOperation(value = "swagger test",notes = "search employee sales info")
	@GetMapping(value = "/salesinfo")
	public Map<String,Object> findEmployeeSales() {
		Criteria criteria = new Criteria();
		criteria.setOrderByClause("es_date");
		List<TEmployeeSales> info = employeeSalesService.selectByExample(criteria);
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("info", info);
		return returnMap;
	}
}