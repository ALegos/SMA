package com.epam.testtask.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public final class InputFileReader {
	private static final String FILENAME = "input";
	private static BufferedReader reader = null;

	private InputFileReader() {
		throw new UnsupportedOperationException("It's not possible to create util class instance");
	}

	private static void init() throws IOException {
		reader = new BufferedReader(new FileReader(FILENAME));
	}

	public static String readLineFromFile() throws IOException {
		if (reader == null){
			init();
		}
		String temp = "";
	
		if ((temp = reader.readLine()) == null) {
			reader.close();
			temp = null;
		}
		return temp;
	}

}
