/*
 * Datastructuren Plenaire Assignment
 * By: Wietze Slagman(10165622) & Bram Smit(1066656)
 */

public class HashFunction {
        
    private int hashSize;
    private static final int multiplier = 31;
    private int initial = 1;


    public HashFunction(int hashSize) {
        this.hashSize = hashSize;
    }

    public int getIndex(String key) {
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
