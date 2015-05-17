
public class LintCode_BinarySearch {
	 public int binarySearch(int[] nums, int target) {
	        //write your code here  
	        if(nums == null||nums.length == 0) return -1;
	    	int start = 0;
	    	int end = nums.length - 1;
	    	int index = 0;
	    	
	    	while(start < end - 1){
	    		int mid = (start + end) / 2;
	    		index = mid;
	    		if(nums[mid] == target){
	    		    while(nums[index] == target){
	    		    	index--;
	    		    }
	    			return ++index;
	    		}
	    		if(nums[mid] > target){
	    			end = mid;
	    		}else{
	    			start = mid;
	    		}
	    	}
	    	
	    	if(nums[start] == target)return start;
	    	if(nums[end] == target)return end;
	    	else return -1;     
	  }
	 
	 
	 public static void main(String[] args){
		 LintCode_BinarySearch lt = new LintCode_BinarySearch();
		 int[] nums = {1,2,3,4,5,7,7};
		 int target = 7;
		 System.out.print(lt.binarySearch(nums, target));
	 }
	
}
