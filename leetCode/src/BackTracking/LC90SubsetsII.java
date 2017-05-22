package BackTracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by RuiY on 2017/5/20.
 */
public class LC90SubsetsII {
    public static void main(String[] args){
        int[] nums = {1,2,2,3};

        for(List<Integer> solution : subsetsWithDup(nums)){
            for(int i : solution){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();

        if(nums == null || nums.length == 0){
            return result;
        }

        Arrays.sort(nums);//we always need to sort the array to skip the duplicates

        List<Integer> solution = new LinkedList<>();

        backTrack(result,solution,nums,0);

        return result;
    }

    public static void backTrack(List<List<Integer>> result,List<Integer> solution,int[] nums,int index){
        result.add(new LinkedList(solution));

        for(int i = index;i <nums.length;i++){
            if(i > index && nums[i] == nums[i - 1]){
                continue;
            }
            solution.add(nums[i]);
            backTrack(result,solution,nums,i+1);
            solution.remove(solution.size() - 1);
        }

    }
}
