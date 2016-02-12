

public class HashFunction {
        
    private int hashSize;
    private static final int multiplier = 31;
    private int initial = 1;


    public HashFunction(int hashSize) {
        this.hashSize = hashSize;
    }

    public int calcIndex(String key) {
        int index = Math.abs(HashCode(key)) % hashSize;
        return index;
    }

    private int HashCode(String key) {
        int hash = initial;
        char[] chars = key.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            hash = hash * multiplier + chars[i];
        }   
        return hash;
    }   
}       
