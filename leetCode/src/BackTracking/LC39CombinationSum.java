package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by RuiY on 2017/5/18.
 */
public class LC39CombinationSum {
    public List<List<Integer>> getCombinationSum(int[] nums,int target){
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(list,new ArrayList<>(),nums,target,0);
        return list;
    }

    public void backTrack(List<List<Integer>> list, List<Integer> tempList,int[] nums,int remain,int start){
        if(remain < 0){
            return;
        }else if(remain == 0){
            list.add(new ArrayList<>(tempList));
        }else{
            for(int i = start;i < nums.length;i++){
                tempList.add(nums[i]);
                backTrack(list,tempList,nums,remain - nums[i],i);//not i + 1 because we can reuse the same element
                tempList.remove(tempList.size() - 1);
            }
        }
    }

}
