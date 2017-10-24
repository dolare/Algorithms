public class LC58LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        int count = 0, len = s.length() - 1;
        
        while(len > 0 && s.charAt(len) == ' '){
            len--;
        }
        
        while(len > 0 && s.charAt(len) != ' '){
            len--;
            count++;
        }
        
        return count;
        
    }
    
    public static void main(String[] args){
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("Hello Word  "));
    }
}
