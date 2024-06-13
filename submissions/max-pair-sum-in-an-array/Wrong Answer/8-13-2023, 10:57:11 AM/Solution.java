// https://leetcode.com/problems/max-pair-sum-in-an-array

class Solution {
    public int maxSum(int[] nums) {
        int len = nums.length;
        
        int max= 0;
        
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++ ){
                
              
                if(md(nums[i])==md(nums[j])){
                    max = Math.max(max, nums[i]+nums[j]);
                }
                
            }
        }
        
        return max/10==0? -1 : max;
    }
    
    
    private int md (int a){
        
        int max = 0;
        while(a>0){
            max = Math.max(max, a%10);
            a/=10;
        }
        
        return max;
        
        
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