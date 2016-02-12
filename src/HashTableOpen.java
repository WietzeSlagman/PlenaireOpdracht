

public class HashTableOpen {
    private static final int DEFAULT_CAPACITY = 11;
    private static final int DEFAULT_STEP_SIZE = 1;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    private HashFunction function;
    private tableEntry[] hashArray;
    private int entries = 0;

    public HashTableOpen(int hashSize, HashFunction function) {
    	this.function = function;
    	hashArray = new tableEntry[hashSize];
    }
	
    public HashTableOpen(HashFunction function) {
    	this.function = function;
    	hashArray = new tableEntry[DEFAULT_CAPACITY];
    }    

    public HashTableOpen(int hashSize) {
       	hashArray = new tableEntry[hashSize];
    }

	public HashTableOpen() {
		hashArray = new tableEntry[DEFAULT_CAPACITY];
	}    

	public void put(String key, String value) {
		int index = HashFunction(key);

        // If the loadfactor is not ideal resize the array
        if(((double) (entries+1)/hashArray.length) > loadFactor){
            resize();
        }
        // If the spot at this index is already taken calculate a new index until youve found an empty one
        while (hashArray[index] != null) {
            index = (index + stepSize) % hashSize
        }
        hashArray[index] = new tableEntry(key,value);
        entries ++;
	}

	// public String get(String key) {
	// 	// return value
	// }
	
	public int getSize() {
		return hashSize;
	}

	private void resize() {
		hashSize *= 2;
        function = new HashFunction(hashSize);

        for (int i = 0; i < hashSize/2)