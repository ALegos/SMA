package com.epam.testtask;

import java.io.IOException;

import com.epam.testtask.logic.DataProcessing;

public class Main {
	public static void main(String[] args) {
		try {
			DataProcessing.run(5);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
