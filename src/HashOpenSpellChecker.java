public class HashOpenSpellChecker {
    private int correct;
    private long time;
    private hashTableOpen wordsList;
    private String[] sampleList;


    public ArraySpellChecker(hashTableOpen wordsList, String[] sampleList){
        this.wordsList = wordsList;
        this.sampleList = sampleList;
    }

    public void spellCheck(){
        correct = 0;
        long startTime = System.nanoTime();

        for(int i = 0; i < sampleList.length; i++){
            String checkedWord = wordsList.get(sampleList[i]);
            
            if(sampleList[i].equals(checkedWord)){
                correct ++;
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