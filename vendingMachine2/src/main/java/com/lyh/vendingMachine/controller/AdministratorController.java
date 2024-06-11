package com.lyh.vendingMachine.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lyh.vendingMachine.dto.Product;
import com.lyh.vendingMachine.service.CashService;
import com.lyh.vendingMachine.service.ProductService;
import com.lyh.vendingMachine.service.SalesService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AdministratorController {
	@Autowired ProductService productService;
	@Autowired SalesService salesService;
	@Autowired CashService cashService;
	
	@GetMapping("/admin")
	public String admin(Model model) {
		// 제품 리스트 출력
		List<Product> list = productService.getList();
		model.addAttribute("list", list);
		
		// 전체 수입 출력
		int totalRevenue = salesService.totalRevenue();
		model.addAttribute("totalRevenue", totalRevenue);
		
		// 제품별 수입 출력
		List<Map<String, Object>> productRevenue = salesService.productRevenue();
		model.addAttribute("productRevenue", productRevenue);
		
		// 현금 재고 출력
		List<Map<String, Object>> cashStock = cashService.cashStock();
		model.addAttribute("cashStock", cashStock);
		
		return "administrator";
	}
	
	@PostMapping("/updatePrice")
	public String updatePrice(@RequestParam Map<String, Object> params) {
		log.debug("제품키 디버깅 : " + params.get("productKey"));
		log.debug("업데이트할 가격 디버깅 : " + params.get("updatePrice"));
		productService.priceUpdate(params);
		return "redirect:/admin";
	}
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestParam Map<String, Object> params) {
		log.debug("추가할 상품 이름 : " + params.get("productName"));
		log.debug("추가할 상품 가격 : " + params.get("productPrice"));
		productService.addProduct(params);
		return "redirect:/admin";
	}
	
	@PostMapping("/delProduct")
	public String delProduct(@RequestParam Map<String, Object> params) {
		log.debug("제거할 상품 번호 : " + params.get("productKey"));
		log.debug("제거할 상품 이름 : " + params.get("productName"));
		productService.delProduct(params);
		return "redirect:/admin";
	}
	
	@PostMapping("/addCashStock")
	public String addCashStock(@RequestParam Map<String, Object> params) {
		log.debug("재고추가할 화폐번호 : " + params.get("cashKey"));
		log.debug("재고추가할 화폐단위 : " + params.get("cashType"));
		log.debug("몇개를 추가할지 : " + params.get("addCashStock"));
		cashService.addCashStock(params);
		return "redirect:/admin";
	}
	
	@PostMapping("/addStock")
	public String addStock(@RequestParam Map<String, Object> params) {
		log.debug("제품키 디버깅 : " + params.get("productKey"));
		log.debug("추가할 재고 갯수 디버깅 : " + params.get("addStock"));
		productService.addUpdate(params);
		return "redirect:/admin";
	}
}
