package BackTracking;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by RuiY on 2017/5/22.
 */
public class LC131PalindromePartitioning {
    public static void main(String[] args){
        String s = "aab";
        for(List<String> list :  new LC131PalindromePartitioning().partition(s)){
            for(String str : list){
                System.out.println(str);
            }
        }

    }
    public List<List<String>> partition(String s){
        List<List<String>> result = new LinkedList<>();

        if(s == null || s.length() == 0){
            return result;
        }

        List<String> solution = new LinkedList<>();

        backTrack(result,solution,s,0);

        return result;
    }

    public void backTrack(List<List<String>> result,List<String> solution,String s,int index){
        if(index == s.length()){
            result.add(new LinkedList(solution));
        }else{
            for(int i = index;i < s.length();i++){
                if(this.isPalindrome(s,index,i)){
                    solution.add(s.substring(index,i+1));
                    backTrack(result,solution,s,i+1);
                    solution.remove(solution.size() - 1);
                }
            }
        }

    }

    public boolean isPalindrome(String s,int low,int high){
        if(s == null || s.length() == 0){
            return false;
        }
        while(low < high){
            if(s.charAt(low) != s.charAt(high)){
                return false;
            }
            low++;
            high--;
        }

        return true;
    }
}
