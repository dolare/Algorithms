
public class LintCode_FirstBadVersion {
	 /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
     	int start = 1;
    	int end = n;
    	int mid = 0;
    	while(start < end - 1){
    		mid = (start + end) /2;
    		if(VersionControl.isBadVersion(mid)){
    			end = mid;
    		}else start = mid;
    	}	
    	if(VersionControl.isBadVersion(start)) return start;
    	return end;
    	
    }
    
}
