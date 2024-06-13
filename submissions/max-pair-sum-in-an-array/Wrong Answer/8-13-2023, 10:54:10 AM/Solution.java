// https://leetcode.com/problems/max-pair-sum-in-an-array

class Solution {
    public int maxSum(int[] nums) {
        int len = nums.length;
        
        int max= 0;
        
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++ ){
                
                int val = nums[i] + nums[j];
                
                if(eq(val)){
                    max = Math.max(max, val);
                }
                
            }
        }
        
        return max/10==0? -1 : max;
    }
    
    private boolean eq(int a){
        
       int d = a%10;
        
        while(a>0){
            
            if(a%10==d){
                a/=10;
                continue;
            }else
                return false;
            
        }
       
        
        return true;
        
        
    }
    
    
    
    
}