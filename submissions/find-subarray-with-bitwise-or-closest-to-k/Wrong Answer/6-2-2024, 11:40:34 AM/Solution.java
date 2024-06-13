// https://leetcode.com/problems/find-subarray-with-bitwise-or-closest-to-k

class Solution {
    public int minimumDifference(int[] nums, int k) {
        //10 : 1 0 1 0
            
        
        int pre = nums[0];
        
        int min = Integer.MAX_VALUE;
        int res = min;
        
        int len = nums.length;
        
        for(int i=0;i<len; i++){
            int n = nums[i];
            
            if(Math.abs((pre & n)-k) < min){
                pre &= n;
                
                min = Math.min(min, Math.abs(pre-k));
            }else if(i<len-1){
                pre = nums[i+1];
                
            }
        }
        
        pre = nums[len-1];
        for(int i=len-1; i>=0; i--){
            int n = nums[i];
            if(Math.abs((pre & n)-k) < min){
                pre&=n;
                
                min = Math.min(min, Math.abs(pre-k));
            }else if(i>0){
            
                pre = nums[i-1];
            }
        }
        return min;
        // 5 : 1 1 1 
        // 4 : 1 0 0
        
        // 6 : 1 1 0 , k==2
        
        
        
        
        
    }
}