// https://leetcode.com/problems/split-the-array-to-make-coprime-products

class Solution {
    public int findValidSplit(int[] nums) {
        
        
        long all = 1;
        for(int n : nums){
            all*=n;
        }
        System.out.println(all);
        
        int len = nums.length;
        long prod = 1;
        for(int i=0; i<len-1; i++){
            
            prod*=nums[i];
            if(isCoprime(prod, all/prod))
                return i;
            
            
        }
        return -1;
        
        
    }
    
    private boolean isCoprime(long a, long b){
        
        return gcd(a, b)==1;
    }
    
    
    private long gcd(long a, long b){
        
        if(b==0){
            long t = a;
            a=b;
            b=t;
        }
        
        if(a%b==0)
            return b;
            
        return gcd(b, a%b);
        
        
    }
}