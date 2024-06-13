// https://leetcode.com/problems/maximum-prime-difference

class Solution {
    public int maximumPrimeDifference(int[] nums) {
        
        int max = 0;
        Integer last = null;
        
        for(int i=0; i<nums.length; i++){
            
            if(isPrime(nums[i])){
                
                // System.out.println(nums[i]);
                
                if(last==null)
                    last = i ;
                else{
                    max = Math.max(max, i-last);
                    // last = i;
                } 
                    
                
                
            }
        }
        
        return max;
        
    }
    
    
      public boolean isPrime(int n)
    {
        if(n<2)
        {
            return false;
        }
        for(int i=2;i<=Math.sqrt(n);i++)
        {
            if(n%i==0)
            {
                return false;
            }
        }
        return true;
    }
}