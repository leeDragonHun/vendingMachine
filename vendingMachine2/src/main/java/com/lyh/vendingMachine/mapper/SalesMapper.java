package com.lyh.vendingMachine.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SalesMapper {
	int addSales(Map<String, Object> params);
	int totalRevenue();
	List<Map<String, Object>> productRevenue();
}
