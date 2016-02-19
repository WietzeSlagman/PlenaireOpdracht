

public class HashTableOpen {
    private static final int DEFAULT_CAPACITY = 11;
    private static final int DEFAULT_STEP_SIZE = 1;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    private HashFunction function;
    private tableEntry[] hashArray;
    private double loadFactor = DEFAULT_LOAD_FACTOR;
    private int entries = 0;

    public HashTableOpen(int hashSize, double loadFactor) {
    	this.loadFactor = loadFactor;
    	hashArray = new tableEntry[hashSize];
    	function = new HashFunction(hashSize);
    }
	
    public HashTableOpen(int hashSize) {
       	hashArray = new tableEntry[hashSize];
       	function = new HashFunction(hashSize);
    }
    
    public HashTableOpen(double loadFactor) {
        this.loadFactor = loadFactor;
    	hashArray = new tableEntry[DEFAULT_CAPACITY];
    	function = new HashFunction(DEFAULT_CAPACITY);
    }    
    
	public HashTableOpen() {
		hashArray = new tableEntry[DEFAULT_CAPACITY];
		function = new HashFunction(DEFAULT_CAPACITY);
	}    
	
	
	public void put(String key, String value) {
		int index = function.getIndex(key);

        // if the table exceeds the loadfactor resize the table
        if(((double) (entries+1)/hashArray.length) > loadFactor){
            resizeTable();
        }
    	// in case of collision add step size to index
        while (hashArray[index] != null) {
            index = (index + DEFAULT_STEP_SIZE) % hashArray.length;
        }
        hashArray[index] = new tableEntry(key,value);
        entries++;
	}
    
    /* Returns value hashed to by given key. */
	public String get(String key) {
	    
		int index = function.getIndex(key);
		
		while (hashArray[index] != null) {
    		
    		if (hashArray[index].getKey().equals(key)) {
    		    return hashArray[index].getValue();
    		}
    		
    		// in case of collision add step size to index
    		index = (index + DEFAULT_STEP_SIZE) % hashArray.length;
    	}
		return null;
		
	}

    public tableEntry[] getHashArray() {
        return hashArray;
    }

    public HashFunction getFunction() {
        return function;
    }
        
	private void resizeTable() {
        HashTableOpen newTable = new HashTableOpen(hashArray.length * 2);
        
        for (int i = 0; i < hashArray.length; i++) {
            if (hashArray[i] != null) {
                newTable.put(hashArray[i].getKey(), hashArray[i].getValue());
            }
        }
        hashArray = newTable.getHashArray();
        function = newTable.getFunction();

	}     
}

