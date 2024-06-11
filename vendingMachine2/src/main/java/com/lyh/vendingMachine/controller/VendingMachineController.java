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
import com.lyh.vendingMachine.mapper.SalesMapper;
import com.lyh.vendingMachine.service.BalanceService;
import com.lyh.vendingMachine.service.CashService;
import com.lyh.vendingMachine.service.ProductService;
import com.lyh.vendingMachine.service.SalesService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class VendingMachineController {
	@Autowired BalanceService balanceService;
	@Autowired ProductService productService;
	@Autowired CashService cashService;
	@Autowired SalesService salesService;
	
	@GetMapping("/main")
	public String main(Model model) {
		// 제품 리스트 출력
		List<Product> list = productService.getList();
		model.addAttribute("list", list);
		
		// 잔액 
		int balance = balanceService.showBalance();
		model.addAttribute("balance", balance);
		return "vendingMachine";
	}
	
	@PostMapping("/change")
	public String change(@RequestParam Map<String, Object> params) {
		log.debug("[컨트롤러]잔액 : " + params.get("balance"));
		// 1. cash 서비스로가서 일단 잔액을 선언하고.
		// 잔액을 % / 정처기로직돌리고
		// 종류별로 몇개씩인지 나오면 그걸 반환하는걸로끝
		// 2. 종류별로 나온 거 cash테이블에서 차감하기.
		// 3. balance테이블의 balance칼럼 무조건 0으로 만들기.
		cashService.changeTypeCnt(params);
		return "redirect:/main";
	}
	
	@PostMapping("/buy")
	public String buy(@RequestParam Map<String, Object> params) {
		log.debug("제품키 디버깅 : " + params.get("productKey"));
		log.debug("제품이름 디버깅 : " + params.get("productName"));
		log.debug("제품가격 디버깅 : " + params.get("productPrice"));
		log.debug("제품재고 디버깅 : " + params.get("productStock"));
		productService.subUpdate(params);
		balanceService.balanceSubUpdate(params);
		salesService.addSales(params);
		return "redirect:/main";
	}
	
	@PostMapping("/inputCoin")
	public String inputCoin(@RequestParam Map<String, Object> inputCoin) {
		log.debug("넣은 돈 : " + inputCoin);
		balanceService.balanceAddUpdate(inputCoin);
		cashService.cashAddUpdate(inputCoin);
		return "redirect:/main";
	}
	
	
}
