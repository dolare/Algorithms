public class LC383RansomNote{
  public static boolean canConstruct(String ransomNote, String magazine) {
       int[] charArr = new int[26];

       for(int i = 0; i < magazine.length(); i++){
           charArr[magazine.charAt(i) - 'a']++;
       }

       for(int i = 0; i < ransomNote.length(); i++){
           if(--charArr[ransomNote.charAt(i) - 'a'] < 0){
               return false;
           }
       }

       return true;
    }

    public static void main(String[] args){
        System.out.println(canConstruct("aaa", "aab"));
        System.out.println(canConstruct("aa", "aab"));
    }

}
