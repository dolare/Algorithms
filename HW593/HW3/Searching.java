package test1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Searching {
	
	private static Scanner input;
	public static int binarySearch(ArrayList<Integer> list,int key,int lower,int higher){
			
		  int low = lower;
	      int high = higher + 1;
	      int count = 0;
	      
	      while (low <= high) {
	    	  
	    	  count++;
	          int mid = (low + high) >>> 1;
	          long midVal = list.get(mid);

	          if (midVal < key)
	                low = mid + 1;
	          else if (midVal > key)
	                high = mid - 1;
	          else
	                return count; // key found
	        }
	        return -1;  
	}
	
	
	public static void main(String[] args) {
		
		
		/////////just read file below
		ArrayList<Integer> countNumber = new ArrayList<Integer>();
		countNumber.add(0);
		ArrayList<Integer> countNumber1 = new ArrayList<Integer>();
		
		ArrayList<Integer> targetNumber = new ArrayList<Integer>();
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		int caseNumber = 0;
		
		input = new Scanner (System.in);
		System.out.println("please enter the path of input file: ");
		int[] inputNumbers = null;		
		String fileAddress = input.next();
	
		BufferedReader in = null;
		
		String textLine = null;
		
		String[] tempString = null;
		
		
		try{
			
			in = new BufferedReader(new FileReader(fileAddress));
			
			textLine = in.readLine();
			
			tempString = textLine.split("\\s{1,}");
			
			
			
			for(int i = 0 ;i <= tempString.length;++i){	
				try{
					caseNumber = Integer.parseInt(tempString[i]);
				}catch(Exception e){				
					continue;		
				}
			}
					
			for(int i = 0; i < caseNumber;++i){
			
				textLine = in.readLine();
				
				countNumber.add(Integer.parseInt(textLine));
				
				textLine = in.readLine();
				
				tempString = textLine.split("\\s{1,}");
				
				for(int j = 0; j < tempString.length;++j){
					numbers.add(Integer.parseInt(tempString[j]));
				}
				
				textLine = in.readLine();
				
				targetNumber.add(Integer.parseInt(textLine));
						
			}
			
			int sum = 0;
			for(int i = 0; i < countNumber.size();++i){
				
				sum = countNumber.get(i) +  sum;
				countNumber1.add(sum);
				
			}
					
			System.out.println(caseNumber);
			
			System.out.println(countNumber.toString());
			System.out.println(countNumber1.toString());
			
			System.out.println(targetNumber.toString());
			
			System.out.println(numbers.toString());
					
			System.out.println();
			
		}catch(Exception e){
			e.printStackTrace();
			//System.out.println("error file path or wrong format of the file ....");
			//System.exit(0);
		}
		
		try {
			in.close();
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		
		//  test path of my file  :     C:\\Users\\Dolare\\Desktop\\HW3.txt	
		
		/////////just read file above
		
		
		
		int result = 0;
		for(int i = 0; i < caseNumber;++i){
			result = binarySearch(numbers,targetNumber.get(i),countNumber1.get(i),(countNumber1.get(i + 1)-1));
			if(result != -1 ){
				System.out.println(targetNumber.get(i) + "  " + result);
			}else if(result == -1){
				System.out.println("NOT FOUND " + targetNumber.get(i));
			}
		}

	}
	
	
}
