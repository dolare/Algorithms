class LC680ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return isValidPalindrome(s, l+1,r) || isValidPalindrome(s, l, r-1);
            }
            r--;
            l++;
        }
        
        return true;
    
    }
    
    public static boolean isValidPalindrome(String s, int l, int r){
       while(l < r){
           if(s.charAt(l) != s.charAt(r)){
               return false;
           }
           l++;
           r--;
       }
        return true;
    }
}
