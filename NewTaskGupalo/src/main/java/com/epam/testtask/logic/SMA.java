package com.epam.testtask.logic;

public class SMA {

	public static Long calculatePeriodAvarage(Long[] inputData, int period) {
		Long sum = 0L;
		for (Long temp : inputData) {
			sum += temp;
		}
		return sum / period;
	}
	
	public static Long calculateSMA(Long exluded, Long added, Long sma, int period){
		
		Long result =  sma - exluded/period + added/period;
		
		return result;
	}
}
