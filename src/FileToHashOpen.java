/*
 * Datastructuren Plenaire Assignment
 * By: Wietze Slagman(10165622) & Bram Smit(1066656)
 **************************************************
 * FileToHashOpen creates a dictionary using a HashTable that deals with collisions using linear probing 
 */
 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileToHashOpen {
    private BufferedReader br;
    private String path;

    public FileToHashOpen(String path) {
    	this.path = path;
    }

    public HashTableOpen readLines() {
    	int lineCount = countLines();
    	HashTableOpen hashTable = new HashTableOpen(lineCount);

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
