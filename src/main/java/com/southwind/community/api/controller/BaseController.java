package com.southwind.community.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	int num = 1;

	int size = 10;

	/**
	 * 取得分页开始条数
	 * 
	 * @param currentPage
	 *            当前页数
	 * @param perPage
	 *            每页显示条数
	 * @return int 每页开始条数
	 */
	public int getStartRecord(int currentPage, int perPage) {
		currentPage = currentPage < 1 ? 1 : currentPage;
		return (currentPage - 1) * perPage;
	}

	protected Map<String, String> getErrors(BindingResult result) {
		Map<String, String> map = new HashMap<>();
		List<FieldError> list = result.getFieldErrors();
		for (FieldError error : list) {
			System.out.println("error.getField():" + error.getField());
			System.out.println("error.getDefaultMessage():" + error.getDefaultMessage());

			map.put(error.getField(), error.getDefaultMessage());
		}
		return map;
	}

	public String dateTimeFormatter(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		/*
		 * Instant instant = date.toInstant(); ZoneId zoneId =
		 * ZoneId.systemDefault(); DateTimeFormatter formatter =
		 * DateTimeFormatter.ofPattern("YYYY-MM-DD'T'HH:mm:ss",Locale.ENGLISH);
		 */
		return formatter.format(date);
	}
}
