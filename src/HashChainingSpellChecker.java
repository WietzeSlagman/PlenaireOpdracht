public class HashChainingSpellChecker{
    private int correct;
    private long time;
    private HashTableChaining wordTable;
    private String[] sampleList;


    public HashChainingSpellChecker(HashTableChaining wordTable, String[] sampleList){
        this.wordTable = wordTable;
        this.sampleList = sampleList;
    }

    public void spellCheck(){
        correct = 0;
        long startTime = System.nanoTime();

        for(int i = 0; i < sampleList.length; i++){
            String checkedWord = wordTable.get(sampleList[i]);
 
            if(sampleList[i].equals(checkedWord)){
                correct++;
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