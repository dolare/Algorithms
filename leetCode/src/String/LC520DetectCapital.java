class LC520DetectCapital {
    public boolean detectCapitalUse(String word) {
        if(word == null || word.length() == 0){
            return false;
        }

        int count = 0;
        boolean flag = true;
        
        if(word.charAt(0) >= 65 && word.charAt(0) <= 90 ){
            flag = false;
        }
        
        for(int i = 1; i < word.length(); i++){
            if(word.charAt(i) >= 65 && word.charAt(i) <= 90){
                count++;
            }
        }
        
        System.out.println(count);
        
        if(count == 0  || (count == word.length() - 1 && flag == false)){
            return true;
        }else{
            return false;
        }
    }
}
