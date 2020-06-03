package classProblems;

import java.util.*;

import classProblems.LinkList;

public class Hashing<T> {
	private LinkedList<T> [] HashTable;
	private int HashTableSize;
	
	public Hashing(int size) {
		HashTable = new LinkedList[size];
		for(int i=0;i<size;i++)
			HashTable[i] = new LinkedList();
		this.HashTableSize = size;
	}
	
	public void add(int key,T obj) {
		int hashVal = key%this.HashTableSize;
		this.HashTable[hashVal].add(obj);
	}
	
	public boolean search(int key,T obj) {
		int hashVal = key%this.HashTableSize;
		return this.HashTable[hashVal].contains(obj);
	}

	public void delete(int key,T obj) {
		int hashVal = key%this.HashTableSize;
		this.HashTable[hashVal].remove(obj);
	}
	
}
