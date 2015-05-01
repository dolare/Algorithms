public class Euler37{
	
     boolean  isPrime(int n){
    	if(n == 1) return false;
    	if(n == 2) return true;
    	if(n == 3) return true;
    	//if((n%6 != 1)&&(n%6 != 5)) return false;
    	for(int i = 2;i <= Math.sqrt(n);i ++ ){
    		if(n%i == 0)return false;
    	}
    	 return true;
    }
     
     boolean isInterestingPrime(int n){
    	 int length = String.valueOf(n).length() - 1;
    	 if(isPrime(n)){
    		while(length > 0){
    			int n1_1 = (int)(n/Math.pow(10,length));
    			int n1_2 = (int)(n%Math.pow(10,length));
    			length--;
    			if(!isPrime(n1_1)||!isPrime(n1_2))
    				return false;
    		}
    		return true;
    	 }
    	 else return false;	 
     }
     
     public int getInterestingPrimes(){
    	 int sum = 0;
    	 for(int n = 11,count = 0;count <= 11;n++){
    		 if(isInterestingPrime(n)){
    			 count++;
    			 sum = sum + n;
    			 System.out.print(n + " ");
    			 if(count == 11)break;
    		 }
    	 }
    	 System.out.println();
    	 return sum;
     }
     
     public static void main(String[] args){
    	 long start = System.currentTimeMillis();
    	 Euler37 p23 = new Euler37();
    	 System.out.println("Answer: " + p23.getInterestingPrimes());
    	 long stop = System.currentTimeMillis();
    	 System.out.println("Time used: " + (stop - start) + "ms");
     }

}