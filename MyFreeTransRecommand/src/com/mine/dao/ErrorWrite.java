package com.mine.dao;

import java.io.FileWriter;
import java.io.IOException;

public class ErrorWrite {
	private static FileWriter fileWriter = null;

	public static FileWriter getFileWriter() {
		return fileWriter;
	}

	public static void setFileWriter(FileWriter fileWriter) {
		ErrorWrite.fileWriter = fileWriter;
	}
	public static void write(String str) {
		if(fileWriter == null) {
			return;
		}
		try {
			fileWriter.write(str);
			fileWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close() {
		if(fileWriter == null) {
			return;
		}
		try {
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
