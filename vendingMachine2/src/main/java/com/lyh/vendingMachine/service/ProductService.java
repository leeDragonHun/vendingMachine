package com.lyh.vendingMachine.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyh.vendingMachine.dto.Product;
import com.lyh.vendingMachine.mapper.ProductMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class ProductService {
	@Autowired ProductMapper productMapper;
	
	// 상품 정보 불러오기
	public List<Product> getList(){
		List<Product> list = productMapper.select();
		return list;
	}
	
	// 구매 시 재고 -1 시키는
	public void subUpdate(Map<String, Object> params) {
		productMapper.subUpdate(params);
	}
	
	// 재고 채우기
	public void addUpdate(Map<String, Object> params) {
		productMapper.addUpdate(params);
	}
	
	// 제품 가격 변경
	public void priceUpdate(Map<String, Object> params) {
		productMapper.priceUpdate(params);
	}
	
	// 제품 추가
	public void addProduct(Map<String, Object> params) {
		productMapper.addProduct(params);
	}
	
	// 제품 제거
	public void delProduct(Map<String, Object> params) {
		productMapper.delProduct(params);
	}
}
