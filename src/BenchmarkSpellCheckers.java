

import java.io.File;
import java.io.FilenameFilter;

/*
 * 08/02/2016
 * BenchmarkArray class;
 * Will match sample files with a wordlist read in to an array using one of the FileToArray classes.
 * 
 */

public class BenchmarkSpellCheckers {

    public static void main(String[] args) {
    	String wordListPath = "wordlist.txt";
       	String sampleDir = "Samples";

        // String wordListPath = "C:/Users/Bram/Dropbox/Studie/Datastructuren/PlenaireAssignment/src/wordlist.txt";
        // String sampleDir = "C:/Users/Bram/Dropbox/Studie/Datastructuren/PlenaireAssignment/Samples";
       	
    
        //  apply file filter matching "sample_*" files
       	File dir = new File(sampleDir);
    	FilenameFilter filter = new MyFileFilter();
   	  	File[] sampleFiles = dir.listFiles(filter);    	
    	
    	
    // 	benchmarkArray(wordListPath, sampleFiles, sampleDir);
    	
    	benchmarkHashTableOpen(wordListPath, sampleFiles, sampleDir);
    	
    	benchmarkHashTableChaining(wordListPath, sampleFiles, sampleDir);

    }

    private static void benchmarkArray(String wordListPath, File[] sampleFiles, String sampleDir) {
    
    	// Read in wordList
    	FileToArray_primitive reader = new FileToArray_primitive(wordListPath);
    	String[] wordList = reader.readLines();
        
        long timeAverage = 0;
        // spell check the sample files and benchmark this process
    	System.out.println("Array bechmarking has started, please wait......");
    	for (File f : sampleFiles) {
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
    
    
    private static void benchmarkHashTableOpen(String wordListPath, File[] sampleFiles, String sampleDir) {
    	// Read in wordList
    	FileToHashOpen wordReader = new FileToHashOpen(wordListPath);
        HashTableOpen wordTable = wordReader.readLines();
	    
	    int timeAverage = 0;
        // spell check the sample files and benchmark this process
        System.out.println("HashTableOpen bechmarking has started, please wait......");
    	for (File f : sampleFiles) {

    		FileToArray_primitive sampleReader = new FileToArray_primitive(sampleDir + "/" + f.getName());
    		String[] sampleList = sampleReader.readLines();
    		HashOpenSpellChecker spellChecker = new HashOpenSpellChecker(wordTable, sampleList);
    		spellChecker.spellCheck();
    		
    	    // get results
    		int correct = spellChecker.getCorrect();
            int total = sampleReader.countLines();
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
    
    
    private static void benchmarkHashTableChaining(String wordListPath, File[] sampleFiles, String sampleDir) {
    	// Read in wordList
    	FileToHashChaining wordReader = new FileToHashChaining(wordListPath);
        HashTableChaining wordTable = wordReader.readLines();
	    
	    int timeAverage = 0;
        // spell check the sample files and benchmark this process
        System.out.println("HashTableChaining bechmarking has started, please wait......");
    	for (File f : sampleFiles) {

    		FileToArray_primitive sampleReader = new FileToArray_primitive(sampleDir + "/" + f.getName());
    		String[] sampleList = sampleReader.readLines();
    		HashChainingSpellChecker spellChecker = new HashChainingSpellChecker(wordTable, sampleList);
    		spellChecker.spellCheck();
    		
    	    // get results
    		int correct = spellChecker.getCorrect();
            int total = sampleReader.countLines();
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
