// https://leetcode.com/problems/prime-in-diagonal

class Solution {
    
    HashMap<Integer, Boolean> map = new HashMap<>();
    
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
        
        if(map.containsKey(n))
            return map.get(n);
        
        if (n < 3) {
            map.put(n, n>1);
            return n > 1;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                map.put(n, false);
                return false;
                
            }
        }
        
        map.put(n, true);
        
        return true;
    }
    
    
}