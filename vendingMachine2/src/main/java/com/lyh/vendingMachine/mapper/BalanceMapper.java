package com.lyh.vendingMachine.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BalanceMapper {
	int select();
	int addUpdate(Map<String, Object> inputCoin);
	int subUpdate(Map<String, Object> params);
}
