package com.epam.testtask.logic;

import java.io.IOException;

import com.epam.testtask.io.InputFileReader;
import com.epam.testtask.io.OutputFileWriter;

public class DataProcessing {

	private static Long parse(String input){
		return Long.parseLong(input.split(",")[1]);
	}
	
	public static void run(int period) throws IOException{
		String temp ="";
		int i=0;
		
		Long[] valueArray = new Long[period];
		while(i<period){
			temp = InputFileReader.readLineFromFile();
			valueArray[i++] = parse(temp);
		}
		Long currentSMA = SMA.calculatePeriodAvarage(valueArray, period);
		OutputFileWriter.writeLineToFile(temp, currentSMA);
		while(true){
			temp = InputFileReader.readLineFromFile();
			if (temp == null){
				OutputFileWriter.close();
				break;
			}
			Long tempExcluded = valueArray[i % period];
			valueArray[i % period] = parse(temp);
			currentSMA = SMA.calculateSMA(tempExcluded, valueArray[i++ % period], currentSMA, period);
			OutputFileWriter.writeLineToFile(temp, currentSMA);
			
		}
	}
	
	
}
