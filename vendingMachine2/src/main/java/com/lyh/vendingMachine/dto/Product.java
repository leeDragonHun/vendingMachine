package com.lyh.vendingMachine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	private int productKey;
	private String productName;
	private int productPrice;
	private int productStock;
	private String updateDate;
}
