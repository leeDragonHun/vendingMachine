package com.lyh.vendingMachine.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.lyh.vendingMachine.dto.Product;

@Mapper
public interface ProductMapper {
	List<Product> select();
	int subUpdate(Map<String, Object> params);
	int addUpdate(Map<String, Object> params);
	int priceUpdate(Map<String, Object> params);
	int addProduct(Map<String, Object> params);
	int delProduct(Map<String, Object> params);
}
