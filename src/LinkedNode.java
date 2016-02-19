 /*
 * Datastructuren Assignment 2
 * By: Wietze Slagman(10165622) & Bram Smit(1066656)
 **************************************************
 * our own implementation of linkedlist only containing the bare necessities for this assignment
 */


public class LinkedNode {	

	LinkedNode next;
	String key;
	String value;
	
	public LinkedNode(String key, String value){
		this.key = key;
		this.value = value;
		this.next = null;
	}

	public LinkedNode(String key, String value, LinkedNode next){
		this.key = key;
		this.value = value;
		this.next = next;
	}
	
	public String getKey(){
		return key;
	}
	
	public String getValue(){
		return value;
	}
	
	public LinkedNode getNext(){
		return next;
	}
	
	public void setNext(LinkedNode next){
		this.next = next;
	}
}

