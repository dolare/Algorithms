package test1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Sorting {
	
	private static Scanner input;

	public static void main(String[] args) throws FileNotFoundException{
		
		input = new Scanner (System.in);
		System.out.println("please enter the path of input file: ");
		String fileAddress = input.next();		
		
		new Sorting().getIntArray(fileAddress);
		
			
	}
	
	public int[] getIntArray(String fileAddress){
		
		String fileName = fileAddress;
		int[] numbers = null;
	
		int numbersOfElements = 0;

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
			
			System.out.println(numbersOfElements);
			numbers = new int[numbersOfElements];
			for(int i = 0, j = index + 1; j < numbersArray.length;i++,j++){
				try{
					numbers[i] =Integer.parseInt(numbersArray[j]);	
				}catch(Exception e){
					i--;continue;
				}
			}
				
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
