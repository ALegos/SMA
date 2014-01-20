package com.epam.testtask.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public final class OutputFileWriter {
	private static final String FILENAME = "output";
	public static BufferedWriter writer = null;

	private OutputFileWriter() {
		throw new UnsupportedOperationException("It's not possible to create util class instance");
	}

	private static void init() throws IOException {
		File file = new File(FILENAME);
		writer = new BufferedWriter(new FileWriter(file, false));
	}

	private static void writeToFile(String data) throws IOException {
		if (writer == null){
			init();
		}
		writer.write(data);
		writer.newLine();
	}
	
	public static void close() throws IOException{
		writer.close();
	}

	public static void writeLineToFile(String temp, Long sma) throws IOException{
		StringBuilder builder = new StringBuilder();
		builder.append(temp).append(",").append(sma.toString());
		System.out.println(builder.toString());
		writeToFile(builder.toString());
	}
	
	
}
