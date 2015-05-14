

public class LintCode_TwoStringsAreAnagrams {
	   public boolean anagram(String s, String t) {
	        // write your code here
		   int slength = s.length();
	       int tlength = t.length();
	        
	        if(s == null || t == null||slength != tlength){
	            return false;
	        }
	        
	        int[] count = new int[1000];
	        
	        for(int i = 0;i < slength;i++ ){
	        	count[(int)s.charAt(i)]++;
	        }
	        for(int i = 0;i < tlength;i++ ){
	        	count[(int)t.charAt(i)]--;
	        	if(count[(int)t.charAt(i)] < 0){
	        		return false;    		
	        	}
	        }
	        
	        return true;
	  }
	   
	   public static void main(String[] args){
		  String s="abcd", t="dcab";
		  System.out.print(new LintCode_TwoStringsAreAnagrams().anagram(s,t));
	   }
}
