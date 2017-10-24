package BackTracking;

/**
 * Created by RuiY on 2017/5/30.
 */
import java.util.*;

public class LC77Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();

        if(n < 1 || k <= 0){
            return result;
        }

        List<Integer> solution = new LinkedList<>();

        backTrack(n,k,1,solution,result);

        return result;
    }

    public static void backTrack(int n,int k,int index,List<Integer> solution,List<List<Integer>> result){
        if(solution.size() == k){
            result.add(new LinkedList(solution));
        }

        for(int i = index;i <= n;i++){
            solution.add(i);
            backTrack(n,k,i+1,solution,result);
            solution.remove(solution.size() - 1);
        }
    }

}
