/*
 * 05/02/2016
 * FileToArray_primitive class;
 * Is able to read words from a corpus and save these is an array.
 * 
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileToHashChaining {
    private BufferedReader br;
    private String path;

    public FileToHashChaining(String path) {
    	this.path = path;
    }

    public HashTableChaining readLines() {
    	int lineCount = countLines();
    	HashTableChaining hashTable = new HashTableChaining(lineCount);

    	try {
    		br = new BufferedReader(new FileReader(path));

			for (int i = 0; i < lineCount; i++) {
                String line = br.readLine();
				hashTable.put(line, line);
			}
			br.close();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return hashTable;
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
