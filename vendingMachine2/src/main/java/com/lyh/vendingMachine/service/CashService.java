package com.lyh.vendingMachine.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyh.vendingMachine.mapper.CashMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class CashService {
	@Autowired CashMapper cashMapper;
	
	public void cashAddUpdate(Map<String, Object> inputCoin) {
		cashMapper.addUpdate(inputCoin);
	}
	
	public List<Map<String, Object>> cashStock(){
		List<Map<String, Object>> cashStock = cashMapper.cashStock();
		return cashStock;
	}
	
	public void addCashStock(Map<String, Object> params) {
		cashMapper.addCashStock(params);
	}
	
	// 잔돈 종류별 개수 구하기
	public List<Map<String, Object>> changeTypeCnt(Map<String, Object> params){
		List<Map<String, Object>> changeTypeCnt = new ArrayList<>();
		log.debug("[서비스] 잔액: " + params.get("balance"));
		int balance = Integer.parseInt(params.get("balance").toString());
		// 여기까지했음!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		return changeTypeCnt;
	}
}
