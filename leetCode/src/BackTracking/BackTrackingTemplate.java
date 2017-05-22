/*
package BackTracking;

import java.util.LinkedList;
import java.util.List;

*/
/**
 * Created by RuiY on 2017/5/18.
 *//*

public class BackTrackingTemplate {
    public static List<List<Object>> backtrack(int[] A){
        //set up a list  to hold all possible solutions
        List<List<Object>> result = new LinkedList<>();

        if(A == null || A.length == 0){
            return result;
        }

        //as we need to recursively generate every solution
        //a variable is needed to store single solution
        List<Object> solution = new LinkedList<>();

        //the process of constructing the solution corresponds exactly to
        //doing a Depth first search of the backtrack tree. viewing backtracking as
        //a Depth frist search on a tree yields a natural recursive implementation of the algorithm
        dfs(result,solution,A,0);
        return result;
    }


    private static void dfs(List<List<Object>> resut,List<Object> solution,int[] A, int pos){
        //for recursion, the first thing we need to think about is how to terminate it.
        //method isASolution could be implemented as a private method which returns boolean
        ///or for simple test we can directly use the condition replace if, generate all subsets
        //we can write the condition:if(A.length == pos)

        if(isASolution(A,pos)){
            return;
        }


        for(int i = pos；i < A.length;i++){
            //before Depth first search,we should decide whether we need to prune searching
            //which means its unnecessary to continue search along a wrong partial solution
            if(!isValid(A[i]))continue;//stop searching along this path

            //add the ith element of the array into the partial solution
            //before searching, we need to record the latest element we are suing
            //to build the solution tree, method makemove should be able to add A[i
            //to the solution, i.e, solution.add(A[i])

            makeMove(solution);

            //right now, we are searching all possible solutions based on ith element.
            //warning: remember as we've already added ith element,the last parameter must be i + 1
            dfs(result,solution,A,i + 1);

            //after searching based on ith element, tabke back the move and search another possible partial solution
            unmakeMove(solution,A[i]);
        }
    }
}
*/
