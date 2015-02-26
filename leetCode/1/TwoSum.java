package test1;

import java.awt.List;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

public class TwoSum {
	
	public int[] twoSum(int[] numbers, int target) {
		 HashMap<Integer,Integer> numbersHash = new HashMap<Integer,Integer>();
		    for(int i = 0 ;i< numbers.length;i++){
		        numbersHash.put(i,numbers[i]);
		   }	   
		    int[] result = new int[2];
		    int m = 0;
		    for(int i = 0 ;i< numbers.length;i++){
		    	int temp = target - numbers[i];
		    	if(numbersHash.containsValue(temp)){
		    		result[m] = i + 1;m++;
		    	}
		    }
		    return result;  
	 }
	
	public static void main(String[] args){
		
		int[] numbers = {1,5,6,8,5,6};
		int[] output ;
		long t1 = System.currentTimeMillis(); 
		TwoSum ts = new TwoSum();
		output = ts.twoSum (numbers,9);
		System.out.println();
		
		for(int i = 0;i < output.length;++i){
			System.out.print( output[i] + " ");
		}
		
		 long t2 = System.currentTimeMillis(); 
		System.out.print( "time:" + (t2 - t1) +"ms");
		
		
	}
}
