// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        
        int[] res = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            
            int cnt=0;
            for(int j=0; j<nums.length; j++){
                
                if(i==j){
                    continue;
                }
                
                if(nums[i]>nums[j])
                    ++cnt;
                
                
                
            }
            
            res[i] = cnt;
            
            
        }
        
        return res;
        
    }
}