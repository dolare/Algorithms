package Array;

/**
 * Created by Dolare on 2017/7/25.
 */
public class LC215KthLargestElementInAnArray {



    //let's create a test case
    public static void main(String[] args){
        int[] nums = new int[20];
        java.util.Random myRandom = new java.util.Random();
        System.out.print("numbers are :" );

        for(int i = 0;i < nums.length;i++){
            nums[i] = myRandom.nextInt(100);//each number is random from 0 - 99
            System.out.print(nums[i] + " ");
        }

        System.out.print("the 10th largest value is : " + findKthLargest(nums,10));
    }


    //jiuzhang's solution
    public static int findKthLargest(int[] nums,int k){
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(k <= 0){
            return 0;
        }
        return helper(nums,0,nums.length - 1,nums.length - k + 1);
    }

    //find kth smallest element
    public static int helper(int[] nums,int left, int right, int k){
        if(left == right){
            return nums[left];
        }
        int position = partition(nums,left,right);
        if(position + 1 == k) {
            return nums[position];
        }else if(position + 1 < k){
            return helper(nums,position + 1,right,k);
        }else{
            return helper(nums,left,position - 1,k);
        }
    }

    public static int partition(int[] nums,int left,int right){
        //pivot
        int pivot = nums[left];

        //do partition
        while(left < right){
            while(left < right && nums[right] >= pivot){
                right--;
            }
            nums[left] = nums[right];
            while(left < right && nums[left] <= pivot){
                left++;
            }

            nums[right] = nums[left];
        }

        nums[left] = pivot;

        return left;
    }


 /*   //define the method header
    public static int findKthLargest(int[] nums,int k){
        //firstly make sure ke is valid between (1 and nums.length)
        if(k < 1 || k > nums.length){
            return 0;//let's assume 0 as the default bad signal though in reality we should improve
        }

        //we are going to use quick sort to solve this problem
        return findKthLargest(nums,0,nums.length - 1,k);
    }

    //youtube solution with explaintion
    public static int findKthLargest(int[] nums,int start,int end,int k){
        //this is the key method, the basic idea is to borrow the quick sort algorithm
        //by picking a pivot and put it in place and check if it is value we are looking for
        int pivot = start;//assume pivot pisition is 1st element
        int left = start;
        int right = end;// we keep start/end untouched and copy values for processing in method

        while(left <= right){
            //so we scan from left to rigth until we find a value which is larger than pivot value
            while(left <= right && nums[left] <= nums[pivot]){
                left++;//after this loop, the value at left is larger than pivot position
            }
            while(left <= right && nums[right] >= nums[pivot]){
                right--;//similar for the right one
            }
            //now swap if valid
            if(left < right){
                swap(nums,left,right);
            }
        }

        //now different from quick sort, we firstly check if we can return
        //from here

        //notice ke is nth, start from 1 while index starts from 0
        if(k == right + 1) {
            return nums[right];//we immediately return all as right position value is set
        }else if(k > right + 1) {
            return findKthLargest(nums,right + 1,end,k);
        }else{//we only need to focus on the left half
            return findKthLargest(nums,start,right - 1,k);
        }

    }
    //define a support method to swap
    private static void swap(int[] nums,int index1,int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }*/
}
