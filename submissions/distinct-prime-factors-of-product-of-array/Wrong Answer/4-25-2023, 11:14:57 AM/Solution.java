// https://leetcode.com/problems/distinct-prime-factors-of-product-of-array

class Solution {
    public int distinctPrimeFactors(int[] nums) {
        int len = nums.length;
        
        long prod = 1;
        for(long n : nums){
            prod*=n;
        }
        
        int cnt=0;
        
        for(long i=2; i<Math.sqrt(prod); i++){
            
            while(prod %(i*i)==0)
                prod/=i;
            
            if(prod%i==0 && isPrime((int)i)){
                // System.out.println(i);
                cnt++;
            }
                
            
            
        }
        
        return (int)cnt;
        
        
        
        
    }
    
    
    private boolean isPrime(int n){
        
        if(n<2) return true;
        
        for(int i=2; i<=Math.sqrt(n); i++){
            
            if(n%i==0 )
                return false;
        }
        
        return true;
    }
}