
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class SortingB {
	
	
	static int numbersOfElements1 = 0;
	static int numbersOfElements2 = 0;
	static int numbersOfElements3 = 0;
	private static Scanner input;
	

	public static void main(String[] args){
			
		int key = 0;
		numbersOfElements1 = 1000000;
		numbersOfElements2 = 10000000;
		numbersOfElements3 = 100000000;
		
		System.out.println("Please wait 20s for the Random Array Initial .");
		
		JFrame jf6 = new JFrame();
		jf6.setSize(800, 400);
		jf6.setVisible(true);
		jf6.setLocationRelativeTo(null ); // Center the frame
		//jf6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf6.setTitle("N = 10^6 : ");
		MyPanel jp6 = new MyPanel(1);
		jf6.add(jp6);
		
		JFrame jf7 = new JFrame();
		jf6.setSize(800, 400);
		jf7.setVisible(true);
		jf7.setLocationRelativeTo(null ); // Center the frame
		//jf7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf7.setTitle("N = 10^7 : ");
		MyPanel jp7 = new MyPanel(10);
		jf7.add(jp7);
		
		JFrame jf8 = new JFrame();
		jf6.setSize(800, 400);
		jf8.setVisible(true);
		jf8.setLocationRelativeTo(null ); // Center the frame
		//jf8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf8.setTitle("N = 10^8 : ");
		MyPanel jp8 = new MyPanel(100);
		jf8.add(jp8);
		
		int[] numbers1 = new int[numbersOfElements1];
		int[] numbers2 = new int[numbersOfElements2];
		int[] numbers3 = new int[numbersOfElements3];
		
		
		
		for(int i = 0;i < numbersOfElements1;i++){
			numbers1[i] = new Random().nextInt(10000);
		}
		for(int i = 0;i < numbersOfElements2;i++){
			numbers2[i] = new Random().nextInt(10000);
		}
		for(int i = 0;i < numbersOfElements3;i++){
			numbers3[i] = new Random().nextInt(10000);
		}
		
			int x61 = 0;
			int x62 = 0;
			int y61 = 0;
			int y62 = 0;
			int x71 = 0;
			int x72 = 0;
			int y71 = 0;
			int y72 = 0;
			int x81 = 0;
			int x82 = 0;
			int y81 = 0;
			int y82 = 0;
		
		while(true){
			
			
			boolean bl = true;
			while(bl){
				try{
					input = new Scanner (System.in);
					System.out.println("please enter the key's value you wan to test(you can input 0 to exit the test) :  ");
					key = Integer.parseInt(input.next());	
					if(key < 0){
						throw new Exception();
					}
					if(key == 0){
						System.exit(0);
					}
					bl = false;
				}catch(Exception e){
					System.out.println("error input,please input again");
				}
			}	
				
			long t1 = System.currentTimeMillis(); 
			quickAndInertionSort(numbers1,0,numbersOfElements1 - 1,key);
			long t2 = System.currentTimeMillis(); 
			System.out.println("When the n = 10^6 ,k = " + key + " ,the run time to sort is for the sanme array(element from 1 to 100000) : " + (t2 - t1) + "ms");
			x62 = key;
			y62 = (int)(t2 -t1);
			jp6.paintLine(30 + 20*x61, 300 - y61/5,30 + 20*x62, 300 - y62/5);
			x61 = x62;
			y61 = y62;
			
			t1 = System.currentTimeMillis(); 
			quickAndInertionSort(numbers2,0,numbersOfElements2 - 1,key);
			t2 = System.currentTimeMillis(); 
			System.out.println("When the n = 10^7 ,k = " + key + " ,the run time to sort is for the sanme array(element from 1 to 100000) : " + (t2 - t1) + "ms");
			x72 = key;
			y72 = (int)(t2 -t1);
			jp7.paintLine(30 + 20*x71, 300 - y71/50, 30 + 20*x72, 300 - y72/50);
			x71 = x72;
			y71 = y72;
			
			t1 = System.currentTimeMillis(); 
			quickAndInertionSort(numbers3,0,numbersOfElements3 - 1,key);
			t2 = System.currentTimeMillis(); 
			System.out.println("When the n = 10^8 ,k = " + key + " ,the run time to sort is for the sanme array(element from 1 to 100000) : " + (t2 - t1) + "ms");
			System.out.println();
			x82 = key;
			y82 = (int)(t2 -t1);
			jp8.paintLine(30 + 20*x81, 300 - y81/500, 30 + 20*x82, 300 - y82/500);
			x81 = x82;
			y81 = y82;
			
			
		}
	}
	
	public static void swap(int[] a,int i,int j){
		
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
	}
	
	public static void quickAndInertionSort(int[] a,int low,int high,int k){
		
		if(low > high)return ;
		
	
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
		
		
		   if (low == 0 && high==a.length-1) {
	            for (i = 0; i <= high; i++) {
	                for (j = i; j > 0 && a[j - 1] > a[j]; j--) {
	                    swap(a, j, j - 1);
	                }
	            }
	            return;
	        }		
	}
	
}	


class MyPanel extends JPanel{
	int m = 0;
	
	public MyPanel(int k){
		this.m = k;
	}
	
	public void paint(Graphics g){
		
		g.setColor(Color.BLUE);
		g.drawLine(30, 300, 700, 300);     
		
	    g.drawLine(30, 300, 30, 30);  
	      
	    for(int i = 0;i <= 35;i++){
	    	g.drawString(Integer.toString(i), (30 + 20*i), 310);
	    }
	    g.drawString("n", 700, 300);
	     
	    for(int i = 1;i <= 6;i++){
	    	g.drawString(Integer.toString(i*m*200), 0, (300 - i*40));
	    }
	    g.drawString("Time : ms", 30, 30);
	      
	}
	
	
	public void paintLine(int x1,int y1,int x2,int y2){
	
		 Graphics g = this.getGraphics();
	     g.drawLine(x1, y1, x2, y2);
	      
	}  
}
	