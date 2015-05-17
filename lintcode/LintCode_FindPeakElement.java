
public class LintCode_FindPeakElement {
	 int findPeak(int[] A) {
		 
	        int start = 1, end = A.length - 2;
	        if (A[start] > A[start - 1] && A[start] > A[start + 1])
	        	return start;
	        if (A[end] > A[end - 1] && A[end] > A[end + 1])
	        	return end;
	        
	        while (start <= end ) {
	            int mid = (start + end) / 2;
	            if (A[mid] > A[mid-1] && A[mid] > A[mid+1])
	                return mid;
	            if (A[mid] > A[mid-1])
	                start = mid + 1;
	            else    
	                end = mid - 1;
	        }
	        return -1;
	    }
	 
	 
	 public static void main(String[] args){
		 LintCode_FindPeakElement lt = new LintCode_FindPeakElement();
		 int[] A = {1, 1, 1, 10, 11, 7, 7, 6};
		 System.out.print(lt.findPeak(A));
	 }
	 
}
