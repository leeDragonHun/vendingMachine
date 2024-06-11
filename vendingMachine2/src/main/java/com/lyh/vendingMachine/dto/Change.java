package com.lyh.vendingMachine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Change {
	private int cashBack10000;
	private int cashBack5000;
	private int cashBack1000;
	private int cashBack500;
	private int cashBack100;
	private int cashBack50;
	private int cashBack10;
}
