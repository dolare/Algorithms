package TwoPointer;

import java.util.*;
/**
 * Created by Dolare on 2017/9/6.
 */
public class LC15ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        final int TARGET = 0;
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);

        for(int i = 0;i < nums.length -2;i++){
            int target = TARGET - nums[i];
            int p1 = i+1, p2 = i+2;

            while(p1 < p2){
                if(nums[p1] + nums[p2] == target){
                    result.add(Arrays.asList(nums[i], nums[p1], nums[p2]));
                }
                while(p1 < p2 && nums[p1] == nums[p1 + 1]){
                    p1++;
                }
                while(p1 < p2 && nums[p2] == nums[p2 - 1]){
                    p2--;
                }

                if(nums[p1] + nums[p2] < target){
                    p1++;
                }else {
                    p2--;
                }
            }
        }

        return result;
    }
}
