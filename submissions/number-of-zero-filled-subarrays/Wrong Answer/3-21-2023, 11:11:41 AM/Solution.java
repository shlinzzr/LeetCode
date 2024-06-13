// https://leetcode.com/problems/number-of-zero-filled-subarrays

class Solution {
    
    int res =0;
    
    public long zeroFilledSubarray(int[] nums) {
        int len = nums.length;
        
        long res = 0L;
        
        int i=0; 
        while(i<len){
            
            while(i<len && nums[i]!=0) i++;
            
            int j=i;
            while(i<len && nums[i]==0){
                i++;
            }
         
            
            if(j!=i){
                int n = i-j;
                res+= (n*(1+n))/2;    
                
            }
            
        }
        
        return res;
        
        
    }
    
    
}