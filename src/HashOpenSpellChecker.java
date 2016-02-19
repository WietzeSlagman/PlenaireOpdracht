public class HashOpenSpellChecker {
    private int correct;
    private long time;
    private HashTableOpen wordTable;
    private String[] sampleList;


    public HashOpenSpellChecker(HashTableOpen wordTable, String[] sampleList){
        this.wordTable = wordTable;
        this.sampleList = sampleList;
    }

    public void spellCheck(){
        correct = 0;
        long startTime = System.nanoTime();

        for(int i = 0; i < sampleList.length; i++){
            String checkedWord = wordTable.get(sampleList[i]);
           
            if (i < 10) {
                System.out.println(sampleList[i]);
                if (checkedWord != null) {
                    System.out.println(checkedWord);
                }
            }
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