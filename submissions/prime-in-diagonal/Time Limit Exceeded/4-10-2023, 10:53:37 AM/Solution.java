// https://leetcode.com/problems/prime-in-diagonal

class Solution {
    public int diagonalPrime(int[][] nums) {
        int len = nums.length;
        
        int max = 0;
        
        for(int i=0; i<len; i++){
            
            if(isPrime(nums[i][i]))
                max=Math.max(max, nums[i][i]);
            
            if(isPrime(nums[i][len-i-1]))
                max = Math.max(max, nums[i][len-i-1]);  
        }
        
        return max;
        
        
        
    }
    
    public boolean isPrime(int n) {
        if (n < 3) {
            return n > 1;

        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    
}