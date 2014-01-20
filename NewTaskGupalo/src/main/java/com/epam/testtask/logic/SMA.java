package com.epam.testtask.logic;

public class SMA {

	public static Long calculatePeriodAvarage(Long[] inputData, int period) {
		Long sum = 0L;
		for (Long temp : inputData) {
			sum += temp;
		}
		return sum / period;
	}
}
