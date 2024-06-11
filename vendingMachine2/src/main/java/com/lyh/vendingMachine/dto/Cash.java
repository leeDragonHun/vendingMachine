package com.lyh.vendingMachine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cash {
	private int cashKey;
	private int cashType;
	private int cashStock;
	private String updateDate;
	
}
