import java.util.Arrays;

public class Euler7{
	
	public static void main(String[] args) {
			long start = System.currentTimeMillis();
			boolean[] primes = new boolean[1000000];
			Arrays.fill(primes,true);
			primes[0]=primes[1]=false;
			for(int i=2;i<primes.length;++i){
				if(primes[i]){
					for(int j=i+i;j<primes.length;j+=i)
						primes[j]=false;
				}
			}
			int count = 0;
			for(int i=2;i<primes.length;++i){
				if(primes[i]){
					++count;
					if(count == 10001)
						System.out.println("Answer: " + i);
				}
			}
			
			 long stop = System.currentTimeMillis();
	    	 System.out.println("Time used: " + (stop - start) + "ms");
			
		}

}