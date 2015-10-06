
public class LintCode_strStr {
	  public int strStr(String source, String target) {
	      // write your code here
		  	   if(source == null || target == null){
			   return -1;
		  		}
			   int slength = source.length();
			   int tlength = target.length();
			   
			   if(source.equals(target) || target == "")
				   return 0;		
			
		        for(int i = 0;i < slength - tlength;i++){
		        	int index = i;
		        	for(int j = 0;j < tlength;j++){
		        		if(source.charAt(index++) != target.charAt(j)){
		        			break;
		        		}
		        		if(j == tlength -1){
		        			return i;
		        		}
		        	}
		        }
			   
		        return -1;
	  }
	  
	  public static void main(String[]  args){
		  LintCode_strStr lint_strStr = new LintCode_strStr();
		  System.out.println(lint_strStr.strStr(null, "a"));
	  }
}
