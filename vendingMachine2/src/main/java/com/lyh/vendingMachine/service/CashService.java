package com.lyh.vendingMachine.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyh.vendingMachine.dto.Change;
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
	public Change changeTypeCnt(Map<String, Object> params){
		// 잔돈 담을 dto 생성
		Change change = new Change();
		List<Map<String, Object>> changeTypeCnt = new ArrayList<>();
		log.debug("[서비스] 잔액: " + params.get("balance"));
		int balance = Integer.parseInt(params.get("balance").toString());
		
		// 잔돈 로직
		int cashBack10000 = balance / 10000;
		int cashBack5000 = (balance % 10000) / 5000;
		int cashBack1000 = (balance % 5000) / 1000;
		int cashBack500 = (balance % 1000) / 500;
		int cashBack100 = (balance % 500) / 100;
		int cashBack50 = (balance % 100) / 50;
		int cashBack10 = (balance % 50) / 10;
		
		// 잔돈 로직 디버깅
		log.debug("10,000원의 개수 : "+ cashBack10000);
		log.debug("5,000원의 개수 : "+ cashBack5000);
		log.debug("1,000원의 개수 : "+ cashBack1000);
		log.debug("500원의 개수 : "+ cashBack500);
		log.debug("100원의 개수 : "+ cashBack100);
		log.debug("50원의 개수 : "+ cashBack50);
		log.debug("10원의 개수 : "+ cashBack10);
		
	    // Change 객체에 값을 설정
	    change.setCashBack10000(cashBack10000);
	    change.setCashBack5000(cashBack5000);
	    change.setCashBack1000(cashBack1000);
	    change.setCashBack500(cashBack500);
	    change.setCashBack100(cashBack100);
	    change.setCashBack50(cashBack50);
	    change.setCashBack10(cashBack10);
	    
	    log.debug("잔돈객체에 잘 담겼나 : "+ change);
	    
	    int test = cashMapper.updateCashStock(change);
	    if(test >= 1) {
	    	log.debug("반환한 잔돈만큼 db에서 마이너스 성공!");
	    }
	    
	    cashMapper.updateBalance0();
	    
		return change;
	}
}
