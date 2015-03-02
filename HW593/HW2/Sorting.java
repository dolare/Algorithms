package test1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Sorting {
	
	static int numbersOfElements = 0;
	private static Scanner input;

	public static void main(String[] args) throws FileNotFoundException{
		
		input = new Scanner (System.in);
		System.out.println("please enter the path of input file: ");
		String fileAddress = input.next();		
		
		int[] numbers = new Sorting().getIntArray(fileAddress);
		//      C:\\Users\\Dolare\\Desktop\\HW2.txt
		System.out.println("the result after sorting : ");
		
		quickAndInertionSort(numbers,0,numbersOfElements - 1,7);
		for(int i = 0; i < numbers.length; i++){
			System.out.print(numbers[i] + " ");
		}
				
	}
	
	public static void swap(int[] a,int i,int j){
		
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
	}
	
	public static void quickAndInertionSort(int[] a,int low,int high,int k){
		
		if(low > high)return ;
		
		//recusion if length<7 
		if(low != 0 && high != (a.length - 1) && high - low + 1 < k)
			return;
		
		int i = low + new Random().nextInt(high - low + 1);
		
		swap(a,low,i);
		
		i = low;
		int j= high + 1;
		int x = a[i];
		
		while(true){
			do{
				i++;
			}while(i <= high && a[i] < x);
			
			do{
				j--;
			}while(a[j] > x);
			
			if(j < i)break;
			swap(a,i,j);
		}
		
		swap(a,high,j);
		
		quickAndInertionSort(a,low,j - 1,k);
		quickAndInertionSort(a,j + 1,high,k);
		
		//Insertion sort
		   if (low == 0 && high==a.length-1) {
	            for (i = 0; i <= high; i++) {
	                for (j = i; j > 0 && a[j - 1] > a[j]; j--) {
	                    swap(a, j, j - 1);
	                }
	            }
	            return;
	        }		
	}
	
	public int[] getIntArray(String fileAddress){
		
		String fileName = fileAddress;
		int[] numbers = null;
	
		numbersOfElements = 0;

		BufferedReader in = null;
		
		try{
			in = new BufferedReader(new FileReader(fileName));
	
			String textLine = "";
			String str = "";
			
			while(( textLine =in.readLine())!=null){
			    str += " "+ textLine;
			 }
			String[] numbersArray=str.split("\\s{1,}");
			
				
			int index = 0;
			for(int m = 0; m < numbersArray.length;m++){
				try{
					numbersOfElements =Integer.parseInt(numbersArray[m]);
					index = m;
					break;
				}catch(Exception e){
					continue;
				}
			}	
			
			System.out.println("The length of the intArray : " + numbersOfElements);
			numbers = new int[numbersOfElements];
			for(int i = 0, j = index + 1; j < numbersArray.length;i++,j++){
				try{
					numbers[i] =Integer.parseInt(numbersArray[j]);	
				}catch(Exception e){
					i--;continue;
				}
			}
			
				System.out.println("The input numbers: ");
				for(int i = 0; i < numbers.length; i++){
					System.out.print(numbers[i] + " ");
				}
			
		}catch(FileNotFoundException e){
			System.out.println("The path of file is wrong, the recommendation of path : C:\\Users\\YouName\\Desktop\\HW.txt");
			System.exit(0);
		}catch(Exception e){
			
		}
		
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numbers;
	}
}
