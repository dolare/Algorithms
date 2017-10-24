import java.util.*;

public class LC345ReverseVowelsOfAString {
    public static String reverseVowels(String s) {
        if(s == null || s.length() ==0){
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        
        Set<Character> vowels = new HashSet<>();
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int i = 0, j = sb.length() - 1;
        
        while(i < j){
            
            if(!vowels.contains(sb.charAt(i))){
                i++;
                continue;   
            }
            if(!vowels.contains(sb.charAt(j))){
                j--;
                continue;
            }
            
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);
            
            i++;
            j--;
            
        }
        
        return sb.toString();
        
    }
    
    public static void main(String[] args){
        System.out.println(reverseVowels("leetcode"));
        System.out.println(reverseVowels("hello"));
    }
}
