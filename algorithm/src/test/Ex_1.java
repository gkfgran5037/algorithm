package test;

import java.util.ArrayList;
import java.util.List;

public class Ex_1 {
	public static void main(String[] args) {
		int answer = 0;
		int n = 33;
		
        List<Integer> primeList = new ArrayList<>();
		for(int i=2; i<=1000; i++) {
            boolean isPrime = true;
            
            for(int j=2; j*j<=i; j++) {
                if(i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
            	primeList.add(i);
            }
        }
		int[] prime = primeList.stream().mapToInt(i -> i).toArray();
		
        if(n>=15){
        	for (int i=0; i<prime.length; i++) {
        		if (prime[i]>n) 
					break;
				for (int j=i+1; j<prime.length; j++) {
	        		if (prime[j]>n) 
						break;
					for (int k=j+1; k<prime.length; k++) {
		        		if (prime[k]>n) 
							break;
		        		if ((prime[i]+prime[j]+prime[k])==n)
		        			answer++;
					}
				}
			}
        }   
	}
}
