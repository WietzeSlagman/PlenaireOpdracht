/*
 * Course Datastructures UvA Amsterdam february 2016 
 * Plenaire Assignment
 * Made by:
 *  - Wietze Slagman    10165622
 *  - Bram Smit         10666656
 *
 ******************************************************************************* 
 * BenchmarkSpellCheckers class;
 * Spell checks the sample files against a dictionary implemented with different datastructures;
 *      - Array
 *      - HashTable with linear probing
 *      - HashTable with collision chaining
 * 
 * To initialize the dictionary 3 FileTo[Datastructure] classes are being used;
 *      -FileToArray.java
 *      -FileToHashOpen.java
 *      -FileToHashChaining.java
 *
 * The spell checks are then performed by 3 [Datastructure]SpellChecker classes;
 *      - ArraySpellChecker.java
 *      - HashOpenSpellChecker.java
 *      - HashChainingSpellChecker.java
 * 
 * The hash tables are implemented without using the java.util library;
 *      - HashTable with linear probing :
 *          - HashTableOpen.java
 *          - TableEntry.java
 *      - HashTable with collision chaining :
 *          - HashTableChaining.java
 *          - LinkedNode.java
 *      - HashFunction.java
 *
 * For results and conclusions refer to the report submitted with this assignment.
 */


import java.io.File;
import java.io.FilenameFilter;


public class BenchmarkSpellCheckers {

    public static void main(String[] args) {
    	String wordListPath = "wordlist.txt";
       	String sampleDir = "Samples";

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
    	FileToArray reader = new FileToArray(wordListPath);
    	String[] wordList = reader.readLines();
        
        long timeAverage = 0;
        // spell check the sample files and benchmark this process
    	System.out.println("Array bechmarking has started, please wait......");
    	for (File f : sampleFiles) {
    		reader = new FileToArray(sampleDir + "/" + f.getName());
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
    		
            // optional break to benchmark just one file		
    // 		break;
    
    
    	}
    	System.out.println("Average time per sample file(ns): " + timeAverage / sampleFiles.length);
    }
    
    private static void benchmarkHashTableOpen(String wordListPath, File[] sampleFiles, String sampleDir) {
    	// Read in wordList
    	FileToHashOpen wordReader = new FileToHashOpen(wordListPath);
        HashTableOpen wordTable = wordReader.readLines();
	    
	    int timeAverage = 0;
        // spell check the sample files and benchmark this process
        System.out.println("HashTableOpen bechmarking has started, please wait......");
    	for (File f : sampleFiles) {

    		FileToArray sampleReader = new FileToArray(sampleDir + "/" + f.getName());
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
            
            // optional break to benchmark just one file		
    // 		break;
    	}
    	System.out.println("Average time per sample file(ns): " + timeAverage / sampleFiles.length);
    } 
    
    
    private static void benchmarkHashTableChaining(String wordListPath, File[] sampleFiles, String sampleDir) {
    	// Read in wordList
    	FileToHashChaining wordReader = new FileToHashChaining(wordListPath);
        HashTableChaining wordTable = wordReader.readLines();
	    
	    int timeAverage = 0;
        // spell check the sample files and benchmark this process
        System.out.println("HashTableChaining bechmarking has started, please wait......");
    	for (File f : sampleFiles) {

    		FileToArray sampleReader = new FileToArray(sampleDir + "/" + f.getName());
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
    		
            // optional break to benchmark just one file		
    // 		break;
    	}
    	System.out.println("Average time per sample file(ns): " + timeAverage / sampleFiles.length);
    } 
}
