package com.lyh.vendingMachine.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyh.vendingMachine.mapper.SalesMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class SalesService {
	@Autowired SalesMapper salesMapper;
	
	public void addSales(Map<String, Object> params) {
		salesMapper.addSales(params);
	}
	
	public int totalRevenue() {
		int totalRevenue = salesMapper.totalRevenue();
		return totalRevenue;
	}
	
	public List<Map<String, Object>> productRevenue(){
		List<Map<String, Object>> productRevenue = salesMapper.productRevenue();
		return productRevenue;
	}
}
