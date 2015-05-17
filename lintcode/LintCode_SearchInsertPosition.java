
public class LintCode_SearchInsertPosition {
	 /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
    	if(A == null||A.length == 0) return 0;
        // write your code here
    	int start = 0;
    	int end = A.length - 1;
    	
    	while(start < end - 1){
    		int mid = (start + end) / 2;
    		if(A[mid] == target){
    			return mid;
    		}
    		if(A[mid] > target){
    			end = mid;
    		}else{
    			start = mid;
    		}
    	}
    	
    	if(A[start] >= target)return start;
    	if(A[end] >= target)return end;
    	else return end + 1;
        
    }
    
    public static void main(String[] args){
    	LintCode_SearchInsertPosition lt = new LintCode_SearchInsertPosition();
    	int[] A = null;
    	System.out.print(lt.searchInsert(A, 4));
    }
}
