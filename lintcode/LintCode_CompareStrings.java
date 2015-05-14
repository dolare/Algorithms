
public class LintCode_CompareStrings {
	 public boolean compareStrings(String A, String B) {
		 // write your code here
		   int alength = A.length();
	       int blength = B.length();
	        
	        if(A == null || B == null){
	            return false;
	        }
	        
	        int[] count = new int[200];
	        
	        for(int i = 0;i < alength;i++ ){
	        	count[(int)A.charAt(i)]++;
	        }
	        for(int i = 0;i < blength;i++ ){
	        	count[(int)B.charAt(i)]--;
	        	if(count[(int)B.charAt(i)] < 0){
	        		return false;    		
	        	}
	        }
	        
	        return true;
  }
	  public static void main(String[] args){
		  String s="abcd", t="dcb";
		  System.out.print(new LintCode_CompareStrings().compareStrings(s, t));
	   }
}
