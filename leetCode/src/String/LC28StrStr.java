package String;

/**
 * Created by Dolare on 2017/10/7.
 * implement strStr() which is same with indexOf
 */
public class LC28StrStr {
    public static int strStr(String haystack, String needle){
        for(int p1 = 0;;p1++){
            for(int p2 = 0;;p2++){
                if(p2 == needle.length()){
                    return p1;
                }
                if(p1 + p2 == haystack.length()){
                    return -1;
                }
                if(needle.charAt(p2) != haystack.charAt(p2 + p1)){
                    break;
                }
            }
        }
    }

    public static void main(String[] args){
        String test1_1 = "mississippi";
        String test1_2 = "a";
        System.out.print(strStr(test1_1,test1_2));
    }
}
