package edu.upenn.cit594.processor;

public class CheckExtension {
	/*
	 * Used to check input file's extension eg."json","csv"
	 */
	public static String getFileType(String fileName) {
		int index = fileName.lastIndexOf('.');
		if(index > 0) {
			String extension = fileName.substring(index+1);
			return extension;
		}
		return null;
	}

}
