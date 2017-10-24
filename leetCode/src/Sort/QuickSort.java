package Sort;
import java.util.*;
/**
 * Created by Dolare on 2017/7/25.
 */
public class QuickSort {
    public  static void main(String[] args){
        Random random = new Random();
        int[] nums = new int[5];
        System.out.print("numbers are :");
        for(int i = 0;i < nums.length;i++){
            nums[i] = random.nextInt(100);
            System.out.print(nums[i] + " ");
        }

        quickSort(nums);
        System.out.println();
        System.out.print("result are : ");
        for(int i : nums){
            System.out.print(i + " ");
        }


    }

    public static void quickSort(int[] nums){
        if(nums == null || nums.length == 0){
            return;
        }
        quickSort(nums,0,nums.length - 1);
    }

    public static void quickSort(int[] nums,int left,int right) {
        if(left >= right){
            return;
        }
        int index = patition(nums,left,right);
        // Separately sort elements before
        // partition and after partition
        quickSort(nums,left,index - 1);
        quickSort(nums,index,right);

    }

    public static int patition(int[] nums,int left,int right){
        int pivot = nums[(right - left)/2 + left];
        while(left <= right){
            while(nums[left] < pivot){
                left++;
            }
            while(nums[right] > pivot){
                right--;
            }

            if(left <= right){
                swap(nums,left,right);
                left++;
                right--;
            }
        }

        return left;
    }

    public static void swap(int[] nums,int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
