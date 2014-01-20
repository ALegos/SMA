package com.epam.testtask.logic;

import java.io.IOException;

import com.epam.testtask.io.InputFileReader;
import com.epam.testtask.io.OutputFileWriter;

public class DataProcessing {

	private static Long parse(String input){
		return Long.parseLong(input.split(",")[1]);
	}
	
	public static void run(int period) throws IOException{
		
		int i=0;
		Long[] valueArray = new Long[period];
		while(i<period-1){
			valueArray[i++] = parse(InputFileReader.readLineFromFile());
		}
		while(true){
			String temp = InputFileReader.readLineFromFile();
			if (temp == null){
				OutputFileWriter.close();
				break;
			}
			StringBuilder builder = new StringBuilder();
			valueArray[i++ % period] = parse(temp);
			builder.append(temp).append(",").append(SMA.calculatePeriodAvarage(valueArray, period).toString());
			System.out.println(builder.toString());
			OutputFileWriter.writeLineToFile(builder.toString());
			
		}
	}
}
