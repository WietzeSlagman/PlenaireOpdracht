

public class HashTableOpen {
    private static final int DEFAULT_CAPACITY = 11;
    private static final int DEFAULT_STEP_SIZE = 1;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    private HashFunction function;
    private tableEntry[] hashArray;
    private int loadFactor = DEFAULT_LOAD_FACTOR;
    private int entries = 0;

    public HashTableOpen(int hashSize, int loadFactor) {
    	this.loadFactor = loadFactor;
    	hashArray = new tableEntry[hashSize];
    	function = new HashFunction(hashSize);
    }
	
    public HashTableOpen(int hashSize) {
       	hashArray = new tableEntry[hashSize];
       	function = new HashFunction(hashSize);
    }
    
    public HashTableOpen(int loadFactor) {
        this.loadFactor = loadFactor;
    	hashArray = new tableEntry[DEFAULT_CAPACITY];
    	function = new HashFunction(DEFAULT_CAPACITY);
    }    
    
	public HashTableOpen() {
		hashArray = new tableEntry[DEFAULT_CAPACITY];
		function = new HashFunction(DEFAULT_CAPACITY);
	}    
	
	

	public void put(String key, String value) {
		int index = HashFunction(key);

        // if the table exceeds the loadfactor resize the table
        if(((double) (entries+1)/hashArray.length) > loadFactor){
            resizeTable();
        }
        // Index taken? > loop till empty spot is found
        while (hashArray[index] != null) {
            index = (index + DEFAULT_STEP_SIZE) % hashArray.length
        }
        hashArray[index] = new tableEntry(key,value);
        entries ++;
	}

	// public String get(String key) {
	// 	// return value
	// }
	
	public int size() {
		return hashArray.length;
	}

    public int getStepSize() { 
        return DEFAULT_STEP_SIZE;
    }
    
	private void resizeTable() {
        HashTableOpen newTable = new HashTableOpen(hashArray.length * 2);
        
        for (int i = 0; i < hashSize/2; i++) {
            if (hashArray[i] != null) {
                newTable.put(hashArray[i].getKey(), hashArray[i].getValue());
            }
        }
        hashArray = newTable.get
	}     
        