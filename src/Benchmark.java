

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

/*
 * 08/02/2016
 * BenchmarkArray class;
 * Will match sample files with a wordlist read in to an array using one of the FileToArray classes.
 * 
 */

public class Benchmark {

    public static void main(String[] args) {
    	String wordListPath = "C:/Users/Bram/Dropbox/Studie/Datastructuren/PlenaireAssignment/src/wordlist.txt";
       	String sampleDir = "C:/Users/Bram/Dropbox/Studie/Datastructuren/PlenaireAssignment/Samples";
    	
    	// Read in sample files
    	benchmarkArray(wordListPath, sampleDir);

    }

    private static void benchmarkArray(String wordListPath, String sampleDir) {
    	File dir = new File(sampleDir);
    	FilenameFilter filter = new MyFileFilter();
   	  	File[] files = dir.listFiles(filter);    	

    	// Read in wordList
    	FileToArray_primitive reader = new FileToArray_primitive(wordListPath);
    	String[] wordList = reader.readLines();
    	System.out.println(wordList[1]);

    	for (File f : files) {

    		reader = new FileToArray_primitive(sampleDir + "/" + f.getName());
    		String[] sampleList = reader.readLines();
    		Array benchmarker = new Array(wordList, sampleList);
    		benchmarker.benchmark();
    		int correct = benchmarker.getCorrect();
    		long time = benchmarker.getTime();
    		System.out.println("Correct" + correct);
    		System.out.println("time" + time);
    		break;
    	}
    }
}
