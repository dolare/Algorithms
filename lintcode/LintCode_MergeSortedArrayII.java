import java.util.ArrayList;


public class LintCode_MergeSortedArrayII {
	 public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
         // write your code here B[0] B[n-1]
		ArrayList<Integer> C = new ArrayList<Integer>();
		int aSize = A.size();
		int bSize = B.size();
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
	    
	   
	    while(count1 < aSize  && count2 < bSize){
	    	if(A.get(count1) < B.get(count2)){
	    		C.add(count3++,A.get(count1++));
	    	}else{
	    		C.add(count3++,B.get(count2++));
	    	}
	    }
	    
	    while(count1 < aSize){
	    	C.add(count3++,A.get(count1++));
	    }
	    
	    while(count2 < bSize){
	    	C.add(count3++,B.get(count2++));
	    }
	    return C;
	 }
	 
	 
	 public static void main(String[] args){
		 LintCode_MergeSortedArrayII lt = new LintCode_MergeSortedArrayII();
		 ArrayList<Integer> A= new ArrayList<Integer>();
		 A.add(1);
		 A.add(2);
		 A.add(3);
		 A.add(4);
		 ArrayList<Integer> B= new ArrayList<Integer>();
		 B.add(3);
		 B.add(4);
		 B.add(5);
		 B.add(6);
		 ArrayList<Integer> C = lt.mergeSortedArray(A, B);
		 System.out.print(C.toString());
	 }
}
