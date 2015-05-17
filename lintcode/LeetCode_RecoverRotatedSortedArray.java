import java.util.ArrayList;


public class LeetCode_RecoverRotatedSortedArray {
	   /**
     * @param nums: The rotated sorted array
     * @return: The recovered sorted array
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        
       
        int length = nums.size();
        int index = 0;
        for(int i = 0;i < length - 1; i++){
        	int j = i;
        	if(nums.get(i) > nums.get(++j) ){
        		index = i;break;
        	}
        }
        if(index == 0){
        	return;
        	
        	
        }
        
        for(int i = 0,j = index;i < j; i++,j--){
        	 int temp = nums.get(i);
             nums.set(i, nums.get(j));
             nums.set(j, temp);
        }
        for(int i = index + 1,j = length - 1;i < j; i++,j--){
        	 int temp = nums.get(i);
             nums.set(i, nums.get(j));
             nums.set(j, temp);
        }
        for(int i = 0,j = length - 1;i < j; i++,j--){
        	 int temp = nums.get(i);
             nums.set(i, nums.get(j));
             nums.set(j, temp);
        }
        
    }
    
    
    public static void main(String[] args){
    	LeetCode_RecoverRotatedSortedArray lt = new LeetCode_RecoverRotatedSortedArray();
    	ArrayList<Integer> nums = new ArrayList<Integer>();
    	nums.add(1);
    	nums.add(2);
    	nums.add(3);
    	nums.add(4);
    	nums.add(5);
    	
    	System.out.println(nums);
    	
    	lt.recoverRotatedSortedArray(nums);
    	
    	System.out.print(nums);
    }
}
