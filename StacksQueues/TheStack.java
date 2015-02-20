package test1;
import java.util.Arrays;





public class TheStack{
	private String[] stackArray;
	
	private int stackSize;
	
	private int topOfStack;
	
	TheStack(int size){
		
		stackSize = size;
		
		topOfStack = -1;
		
		stackArray = new String[size];
		
		Arrays.fill(stackArray,"-1");
		
	}
	
	public void push(String input){
		
		if (topOfStack + 1 < stackSize){
			
			topOfStack++;
			
			stackArray[topOfStack] = input;
			
		}else System.out.print("the stack is full");
		
	}
	
	public String pop(){
		
		if (topOfStack >= 0 ){
			
			stackArray[topOfStack] = "-1";
			
			return stackArray[topOfStack--];
			
		}else {
			
			System.out.println("the stack is empty!");
		
			return "-1";
		}
	}
	

	public static void main(String args[]){
		
		TheStack tStack = new TheStack(10);
		
		tStack.push("10");
		
		
		
		tStack.push("15");
		
		
		
		tStack.push("120");
		
		
		
		System.out.println(tStack.pop());
		
		for(int i = 0; i <tStack.stackArray.length;i++){
			System.out.println(tStack.stackArray[i]);
		}
		
	
	}
}