class LC434NumberOfSegmentsInAString {
    public int countSegments(String s) {
        int count = 0;
        boolean flat = true;
        
        for(int i = 0; i < s.length(); i++){
           if(s.charAt(i) != ' '){
               if(flat == true){
                  count++;
                  flat = false;  
               }         
           }else{
               flat = true;
           }
       }    
        return count;
    }
}
