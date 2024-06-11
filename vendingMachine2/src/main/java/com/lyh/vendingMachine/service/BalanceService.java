package com.lyh.vendingMachine.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyh.vendingMachine.mapper.BalanceMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class BalanceService {
	@Autowired BalanceMapper balanceMapper;
	
	public int showBalance() {
		int balance = balanceMapper.select();
		return balance;
	}
	
	public void balanceAddUpdate(Map<String, Object> inputCoin) {
		balanceMapper.addUpdate(inputCoin);
	}
	
	public void balanceSubUpdate(Map<String, Object> params) {
		balanceMapper.subUpdate(params);
	}
}
