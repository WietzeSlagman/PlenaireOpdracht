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
            if (i < 10) {
                System.out.println(sampleList[i]);
            }
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