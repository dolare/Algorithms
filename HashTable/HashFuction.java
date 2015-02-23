package test1;

import java.util.Arrays;

public class HashFuction {
	
	String[] theArray;
	int arraySize ;
	int itemArray = 0;
	
	public static void main(String args[]){
		
		HashFuction hf = new HashFuction(10);
		
		String[] s= {"1","2","5","2"};
		
		hf.hashFuction2(s,hf.theArray);
		
		for(int i = 0 ;i < hf.theArray.length;i++){
			System.out.println(hf.theArray[i] + " ");
		}
	}
	
	HashFuction(int size){
		
		arraySize = size;
		theArray = new String[size];
		Arrays.fill(theArray,"-1");
		
	}
	
	public void hashFuction1(String[] stringForArray,String[] theArray){
		
		for(int n = 0;n < stringForArray.length;n++){
			
			String newElementVal = stringForArray[n];
			
			theArray[Integer.parseInt(newElementVal)] = newElementVal;
			
		}
	}
	
	public void hashFuction2(String[] stringForArray,String[] theArray){
		
		for(int n = 0;n < stringForArray.length;n++){
			
			String newElementVal = stringForArray[n];
			
			int arrayIndex = Integer.parseInt(newElementVal) %29;
			
			System.out.println("Modulus Index = " + arrayIndex + "for value" + newElementVal);
			
			while(theArray[arrayIndex ] != "-1"){
				
				++arrayIndex;
				
				System.out.println("Collision Try " + arrayIndex + " Instead" );
				
				arrayIndex %= arraySize;
			}
			
			theArray[arrayIndex] = newElementVal;
		}
	}
}
