/*
 * Datastructuren Plenaire Assignment
 * By: Wietze Slagman(10165622) & Bram Smit(1066656)
 **************************************************
 * This hashtable class implements the method of collision chaining
 */

public class HashTableChaining {
    private static final int DEFAULT_CAPACITY = 11;
    private HashFunction function;
    private LinkedNode[] hashArray;

    public HashTableChaining(int hashSize) {
       	hashArray = new LinkedNode[hashSize];
       	function = new HashFunction(hashSize);
    }

	public HashTableChaining() {
		hashArray = new LinkedNode[DEFAULT_CAPACITY];
		function = new HashFunction(DEFAULT_CAPACITY);
	}    
	
	public void put(String key, String value) {
		int index = function.getIndex(key);
		
		// if index is empty put a new LinkedNode there
		if (hashArray[index] == null) {
			hashArray[index] = new LinkedNode(key, value);
		// else add the new node to the end of the LinkedNode
		} else {
			LinkedNode currentNode = hashArray[index];
			
			while (currentNode.getNext() != null){
				currentNode = currentNode.getNext();
			}
			
			if (currentNode.getKey() != key) {
				currentNode.setNext(new LinkedNode(key, value));
			}
		}
	}

    /* Returns value hashed to by given key. */
	public String get(String key) {
		int index = function.getIndex(key);
		
        if (hashArray[index] == null){
              return null;
        } else {
        	LinkedNode currentNode = hashArray[index];
			
			// Keep looking through the lists as long as you havent reached the end which is null
			// or until you have found the key matching your given key and return that value
        	while (currentNode != null){
				if (currentNode.getKey().equals(key)){
					return currentNode.getValue();
				} else {
                    currentNode = currentNode.getNext();
				}
        	}
			return null;
    	}
	}
	
    public LinkedNode[] getHashArray() {
        return hashArray;
    }
}

