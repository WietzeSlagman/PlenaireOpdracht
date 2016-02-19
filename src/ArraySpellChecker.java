/*
 * Datastructuren Plenaire Assignment
 * By: Wietze Slagman(10165622) & Bram Smit(1066656)
 **************************************************
 * ArraySpellChecker spell checks words from a sample file against the dictionary 
 */

public class ArraySpellChecker{
    private int correct;
    private long time;
    private String[] wordsList;
    private String[] sampleList;


    public ArraySpellChecker(String[] wordsList, String[] sampleList){
        this.wordsList = wordsList;
        this.sampleList = sampleList;
    }

    public void spellCheck(){
        correct = 0;
        long startTime = System.nanoTime();

        for(int i = 0; i < sampleList.length; i++){
            for(int j = 0; j < wordsList.length; j++){
                
                if(sampleList[i].equals(wordsList[j])){
                    correct +=1;
                    break;
                }
            }
        }
        long endTime = System.nanoTime();
        time = endTime - startTime;
    }

    public int getCorrect(){
        return correct;
    }

    public long getTime(){
        return time;
    }
}