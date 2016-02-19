/*
 * Datastructuren Plenaire Assignment
 * By: Wietze Slagman(10165622) & Bram Smit(1066656)
 **************************************************
 * Overrides java.io.FileNameFilter to ensure correct sample files
 */

import java.io.File;
import java.io.FilenameFilter;

public class MyFileFilter implements FilenameFilter{

	@Override
	public boolean accept(File directory, String fileName) {
		return fileName.matches("sample_.*");
	}	    
}
	