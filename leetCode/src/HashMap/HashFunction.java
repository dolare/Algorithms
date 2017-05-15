package HashMap;

import java.util.Arrays;

/*Key values are assigned to elements in a Hash Table using a Hash Function
 * 
 *what hash function helps to do is to calculate the best index an item should go in
 *index must be small enough for the array size
 *and don't overwrite other data in the Hash Table
 *
 *
 * */
public class HashFunction {
	
	String[] theArray;
	int arraySize;
	int itemsInArray = 0;
	
	public static void main(String[] args) {
		HashFunction theFunc = new HashFunction(30);
		String[] elementsToAdd = {"1","5","6","32"};
		
		theFunc.hashfunction1(elementsToAdd, theFunc.theArray);
		theFunc.displayTheStack();
	}
	
	public void hashfunction1(String[] stringsForArray, String[] theArray){
		
		for(int n = 0;n < stringsForArray.length; n++){
			String newElementVal = stringsForArray[n];
			theArray[Integer.parseInt(newElementVal)] = newElementVal;
		}
	}
	
	HashFunction(int size){
		arraySize = size;
		theArray = new String[size];
		Arrays.fill(theArray,"-1");
	}
	
	public void displayTheStack(){
		
		int increment = 0;
		
	}
}
