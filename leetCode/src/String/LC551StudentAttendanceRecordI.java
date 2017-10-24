public class LC551StudentAttendanceRecordI {
    public static boolean checkRecord(String s) {
        int countA = 0, countL = 0, count = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'A'){
                if(++countA > 1){
                    return false;
                }
            }
            if(s.charAt(i) == 'L'){
                count++;
                countL = Math.max(countL, count);
                if(countL > 2){
                    return false;
                }
            }else{
                count = 0;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args){
        System.out.println(checkRecord("PPALLL"));
        System.out.println(checkRecord("PPALLP"));
    }
}
