package test1;

import java.util.Arrays;

public class TheQueue{
	
	private String[] queueArray;
	
	private int rear,front,queueSize,numberOfItems = 0;
	
	TheQueue(int size){
		queueSize = size;
		
		queueArray = new String[size];
		
		Arrays.fill(queueArray,"-1");
	}
	public void insert(String input){
		
		if(numberOfItems + 1 <= queueSize){
			
			queueArray[rear] = input;
			
			rear++;
			
			numberOfItems++;
			
		}else System.out.println("the queue is full");
	}
	
	public void remove(){
		if(numberOfItems >0){
			queueArray[front] = "-1";
			
			front++;
			
			numberOfItems--;
		}
	}
	
	public void priorityInsert(String input){
		
		int i;
		
		if(numberOfItems == 0){
			insert(input);
		}
		else{
			for(i = numberOfItems -1; i>=0;i--){
				if(Integer.parseInt(input) < Integer.parseInt(queueArray[i])){
					
					queueArray[i+1] = queueArray[i];
							
				}else break;
			}
			
			queueArray[i+1] = input;
			
			rear++;
			
			numberOfItems++;
		}
	}
	
	
	public static void main(String args[]){
		
		TheQueue tQueue = new TheQueue(10);
		
		tQueue.priorityInsert("10");
		
		tQueue.priorityInsert("13");
		
		tQueue.priorityInsert("6");
		
		tQueue.priorityInsert("20");
		
		tQueue.remove();
		
		for(int i = 0; i <tQueue.queueArray.length;i++){
			System.out.print(tQueue.queueArray[i] + " ");
		}
		
	}
}