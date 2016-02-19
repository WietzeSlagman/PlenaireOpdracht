/*
 * Datastructuren Plenaire Assignment
 * By: Wietze Slagman(10165622) & Bram Smit(1066656)
 **************************************************
 * FileToArray creates a dictionary using an array
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileToArray {
    private BufferedReader br;
    private String path;

    public FileToArray (String path) {
    	this.path = path;
    }

    public String[] readLines() {
    	int lineCount = countLines();
    	String[] lines = new String[lineCount];

    	try {
    		br = new BufferedReader(new FileReader(path));

			for (int i = 0; i < lineCount; i++) {
				lines[i] = br.readLine();
			}
    		br.close();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return lines;
    }

    public int countLines() {
    	int lineCount = 0;
    	try {
    		br = new BufferedReader(new FileReader(path));
    		String line = null;
    		while ((line = br.readLine()) != null) {
	 			lineCount++;
	 		}
    		br.close();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return lineCount;
     }
}
