
public class LintCode_MergeSortedArray {
	/**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here B[0] B[n-1]
    	int[] C = new int[m + n];
    	int count1 = m - 1;
    	int count2 = n - 1;
    	int count3 = m + n - 1;
        
       
        while(count1 >= 0 && count2 >= 0){
        	if(A[count1] > B[count2]){
        		A[count3--] = A[count1--];
        	}else{
        		A[count3--] = B[count2--];
        	}
        }
        
        while(count1 >= 0){
        	A[count3--] = A[count1--];
        }
        
        while(count2 >= 0){
        	A[count3--] = B[count2--];
        }
        	  	
    }
    
    
    public static void main(String[] args){
    	LintCode_MergeSortedArray  lt = new LintCode_MergeSortedArray ();
    	int[] A = {1,2,3,0,0};
    	int[] B = {4,5};
    	lt.mergeSortedArray(A, 3, B,2);
    	for(int i = 0;i < A.length;i++){
        	System.out.print(A[i]);
    	}
    }
}
