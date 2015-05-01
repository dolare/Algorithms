

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;


public class SearchSortingB {
	
	
	static int numbersOfElements1 = 0;
	static int numbersOfElements2 = 0;
	static int numbersOfElements3 = 0;
	

	public static void main(String[] args){
			
		int key = 0;
		numbersOfElements1 = 1000000;
		numbersOfElements2 = 10000000;
		numbersOfElements3 = 100000000;
		
		ArrayList<Integer> n10_6 = new ArrayList<Integer>();
		ArrayList<Integer> n10_7 = new ArrayList<Integer>();
		ArrayList<Integer> n10_8 = new ArrayList<Integer>();
	
		
		
		System.out.println("Please wait 20s for the Random Array Initial .");
		System.out.println("The result will be appear by the form of Graph . "
				+   "And the final result will be calculate after about     s");
		
		JFrame jf6 = new JFrame();
		jf6.setSize(1100, 400);
		jf6.setVisible(true);
		jf6.setLocationRelativeTo(null ); // Center the frame
		//jf6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf6.setTitle("N = 10^6 : ");
		jf6.setResizable(false);
		MyPanel jp6 = new MyPanel(1);
		jf6.add(jp6);
		
		JFrame jf7 = new JFrame();
		jf7.setSize(1100, 400);
		jf7.setVisible(true);
		jf7.setLocationRelativeTo(null ); // Center the frame
		//jf7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf7.setTitle("N = 10^7 : ");
		jf7.setResizable(false);
		MyPanel jp7 = new MyPanel(10);
		jf7.add(jp7);
		
		JFrame jf8 = new JFrame();
		jf8.setSize(1100, 400);
		jf8.setVisible(true);
		jf8.setLocationRelativeTo(null ); // Center the frame
		//jf8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf8.setTitle("N = 10^8 : ");
		jf8.setResizable(false);
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
			
			n10_6.add(0);
			n10_7.add(0);
			n10_8.add(0);
			
		key = 1;
		for(;key <= 40;key++){
				
			long t1 = System.currentTimeMillis(); 
			quickAndInertionSort(numbers1,0,numbersOfElements1 - 1,key);
			long t2 = System.currentTimeMillis(); 
			System.out.println("When the n = 10^6 ,k = " + key + " ,the run time to sort is for the sanme array(element from 1 to 100000) : " + (t2 - t1) + "ms");
			x62 = key;
			y62 = (int)(t2 -t1);
			n10_6.add(y62);
			jp6.paintLine(30 + 20*x61, 300 - (int)(y61*1.5),30 + 20*x62, 300 - (int)(y62*1.5));
			x61 = x62;
			y61 = y62;
			
			t1 = System.currentTimeMillis(); 
			quickAndInertionSort(numbers2,0,numbersOfElements2 - 1,key);
			t2 = System.currentTimeMillis(); 
			System.out.println("When the n = 10^7 ,k = " + key + " ,the run time to sort is for the sanme array(element from 1 to 100000) : " + (t2 - t1) + "ms");
			x72 = key;
			y72 = (int)(t2 -t1);
			n10_7.add(y72);
			jp7.paintLine(30 + 20*x71, 300 - (int)(y71*1.5/10), 30 + 20*x72, 300 - (int)(y72*1.5/10));
			x71 = x72;
			y71 = y72;
			
			t1 = System.currentTimeMillis(); 
			quickAndInertionSort(numbers3,0,numbersOfElements3 - 1,key);
			t2 = System.currentTimeMillis(); 
			System.out.println("When the n = 10^8 ,k = " + key + " ,the run time to sort is for the sanme array(element from 1 to 100000) : " + (t2 - t1) + "ms");
			System.out.println();
			x82 = key;
			y82 = (int)(t2 -t1);
			n10_8.add(y82);
			jp8.paintLine(30 + 20*x81, 300 - y81/100, 30 + 20*x82, 300 - y82/100);
			x81 = x82;
			y81 = y82;
					
		}
		
		System.out.println("The result of 10^6's running time: ");
		for(int i = 1;i < n10_6.size();i++){
			
			System.out.print(n10_6.get(i) + "ms  ");
			if(i % 10 == 0)
				System.out.println();
			
		}System.out.println();System.out.println();
			
		System.out.println("The result of 10^6's running time: ");
		for(int i = 1;i < n10_7.size();i++){
			
			System.out.print(n10_7.get(i) + "ms  ");
			if(i % 10 == 0)
				System.out.println();
			
		}System.out.println();System.out.println();
		
		System.out.println("The result of 10^6's running time: ");
		for(int i = 1;i < n10_8.size();i++){
			
			System.out.print(n10_8.get(i) + "ms  ");
			if(i % 10 == 0)
				System.out.println();
			
		}System.out.println();System.out.println();
		
		double phi = (1 + Math.sqrt(5)) / 2;//1.61
		double resphi = 2 - phi;//0.38
		int pivt = (int)(1 + resphi*48);
		System.out.print(n10_6.get(Golden_mean(n10_6,38,2,pivt)) + "ms  is the minimum runtime when  key is " + Golden_mean(n10_6,38,2,pivt) + " in 10^6 ");
		
		System.out.print(n10_7.get(Golden_mean(n10_7,38,2,pivt)) + "ms  is the minimum runtime when  key is " + Golden_mean(n10_7,38,2,pivt) + " in 10^6 ");
		
		System.out.print(n10_8.get(Golden_mean(n10_8,38,2,pivt)) + "ms  is the minimum runtime when  key is " + Golden_mean(n10_8,38,2,pivt) + " in 10^6 ");
		
		
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
	
	public static int Golden_mean(ArrayList<Integer> a, int right, int left, int pivt){
		double phi = (1 + Math.sqrt(5)) / 2;//1.61
		double resphi = 2 - phi;//0.38
		//	int pivt = left + resphi*(right - left);
		int x;
		if ((right - pivt)>(pivt - left))
			x = pivt + (int)(resphi*(right - pivt));   //60
		else
			x = pivt - (int)(resphi*(pivt - left));



		if (Math.abs(a.get(x) - a.get(pivt)) <1)
			return x;
		
		else if (a.get(x) < a.get(pivt))
		{
			if (right - pivt>pivt - left)
			{
				return(Golden_mean(a, right, pivt, x));
			}
			else
				return(Golden_mean(a, pivt, left, x));
		}

		else{
			if (right - pivt > pivt - left)
				return Golden_mean(a, x, left, pivt);
			else return Golden_mean(a, right,x,pivt);
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
		g.drawLine(30, 300, 1050, 300);     
		
	    g.drawLine(30, 300, 30, 30);  
	      
	    for(int i = 0;i <= 50;i++){
	    	g.drawString(Integer.toString(i), (30 + 20*i), 310);
	    }
	    g.drawString("n", 1050, 300);
	     
	    for(int i = 1;i <= 10;i++){
	    	g.drawString(Integer.toString(i*m*20), 0, (300 - i*30));
	    }
	    g.drawString("Time : ms", 30, 30);
	      
	}
	
	
	public void paintLine(int x1,int y1,int x2,int y2){
	
		 Graphics g = this.getGraphics();
	     g.drawLine(x1, y1, x2, y2);
	      
	}  
		
}
	