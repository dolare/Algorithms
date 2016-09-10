class Solution {
    public int strStr(String source, String target) {
	      // write your code here
		  	 if(source == null || target == null){
		  	     return -1;
		  	 }
		  	    
		  	 int len1 = source.length();
		  	 int len2 = target.length();
		  	 
		  	 if(len1 < len2){
		  	     return -1;
		  	 }
		  	
		  	 for(int i = 0;i < len1 - len2 + 1;i++){
		  	     int j = 0;
		  	     for(;j < len2;j++){
		  	         if(source.charAt(i + j) != target.charAt(j)){
		  	             break;
		  	         }
		  	     }
		  	     if(j == len2){
		  	        return i;
		  	     }
		  	 }
		  	 return -1;
	  }
}
