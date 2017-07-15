package BackTracking;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by RuiY on 2017/6/1.
 */
public class LC93RestoreIpAddresses {
    public static void main(String[] args){
        new LC93RestoreIpAddresses()
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<>();


        if (s == null || s.length() == 0 || s.length() > 12) {
            return result;
        }

        StringBuilder sb = new StringBuilder();

        this.backTrack(s,sb,result,0,0);

        return result;
    }


    public  void backTrack(String s, StringBuilder sb,List<String> result,int index,int count){
        if(count > 3){
            return;
        }else if(count == 3 && index == sb.length()){
            result.add(new String(sb.toString()));
        }else{
            for(int i = index;i < s.length();i++){
                String temp = s.substring(index,i+1);
                if(temp.length() > 3 || temp.length() > 1 && temp.charAt(0) == '0' || Integer.parseInt(temp) > 255){
                    break;
                }
                int length = sb.length();
                sb.append(temp);

                if(i + 1 != s.length()){
                    sb.append(".");
                    backTrack(s,sb,result,i+1,count+1);
                }else{
                    backTrack(s,sb,result,i+1,count);
                }
                sb.setLength(length);
            }
        }
    }


}
