package HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dolare on 2017/9/6.
 */
public class LC1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        //define an array as result
        int[] result = new int[2];

        //use map to store index as value and number as key,
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i < nums.length;i++){
            //check if map contains the result before put the index and number into map, can allow us avoid duplicate
            if(map.containsKey(target - nums[i])){
                result[0] = i;
                result[1] = map.get(target - nums[i]);
            }
            map.put(nums[i],i);
        }

        return result;

    }
}
