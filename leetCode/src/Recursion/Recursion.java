package Recursion;

public class Recursion {
	public void recursion(int i){
		if(i == 0)return;
		System.out.println(i);
		recursion(i - 1);
		System.out.println(i);
	}
	
	public static void main(String[] args) {
		Recursion test = new Recursion();
		test.recursion(10);
		
	}
}
