

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

/*
 * 08/02/2016
 * BenchmarkSpellCheckers class;
 * Create, instantiates and benchmarks the classes needed to perform spellcheck on the sample files with different Datastuctures.
 * 
 */

public class BenchmarkSpellCheckers {

    public static void main(String[] args) {
    	String wordListPath = "C:/Users/bwhsm/Dropbox/Studie/Datastructuren/PlenaireAssignment/src/wordlist.txt";
       	String sampleDir = "C:/Users/bwhsm/Dropbox/Studie/Datastructuren/PlenaireAssignment/Samples";
    	
    	// Read in sample files
    	benchmarkArray(wordListPath, sampleDir);

    }

    // 
    private static void benchmarkArray(String wordListPath, String sampleDir) {
        // io.FilenameFilter is used to create a filter for files that start with "sample_"
    	File dir = new File(sampleDir);
    	FilenameFilter filter = new MyFileFilter();
   	  	File[] files = dir.listFiles(filter);    	

    	// read in the wordlist.txt file
    	FileToArray_primitive reader = new FileToArray_primitive(wordListPath);
    	String[] wordList = reader.readLines();


        // spell check the sample files and benchmark this process
    	System.out.println("Array bechmarking has started, please wait......");
        long timeAverage = 0;
    	for (File f : files) {
            
            reader = new FileToArray_primitive(sampleDir + "/" + f.getName());
    		String[] sampleList = reader.readLines();
    		ArraySpellChecker spellChecker = new ArraySpellChecker(wordList, sampleList);
    		spellChecker.spellCheck();

            // get results
    		int correct = spellChecker.getCorrect();
            int total = reader.countLines();
    		long time = spellChecker.getTime();
            timeAverage += time;

            // print results
            System.out.println(f.getName() + ";");
    		System.out.println(correct + "/" + total + " correct");
    		System.out.println("time(ns): " + time);
            System.out.println("time(s): " + time / 1000000000);
    		break;
    	}
        System.out.println("Average time per sample file(ns): " + timeAverage);
    }
}
