package com.lyh.vendingMachine.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CashMapper {
	int addUpdate(Map<String, Object> inputCoin);
	List<Map<String, Object>> cashStock();
	int addCashStock(Map<String, Object> params);
}
