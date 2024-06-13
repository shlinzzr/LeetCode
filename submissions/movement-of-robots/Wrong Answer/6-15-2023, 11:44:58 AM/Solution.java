// https://leetcode.com/problems/movement-of-robots

class Solution {
    public int sumDistance(int[] nums, String s, int d) {
        int len = nums.length;
        
        
        while(d>0){
            
            for(int i=0; i<len; i++){
            
                char ch = s.charAt(i);
                
                if(ch=='R'){
                    nums[i]++;

                }else{
                    nums[i]--;
                }
            }
            
            d--;
        }
        
        int res =0;
        for(int i=0; i<len; i++){
            
            for(int j=i+1; j<len; j++){
                
                res += Math.abs(nums[i]-nums[j]);
                
            }
            
        }
        
        return res;
        
       
    }
}