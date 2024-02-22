// https://leetcode.com/problems/house-robber-iv

class Solution {
    public int minCapability(int[] nums, int k) {
        
        int len = nums.length;
        int st=0, ed =(int)1e9+7;
        
        while(st<ed){
            
            int ca = st+(ed-st)/2;
            int take=0;
            for(int i=0; i<nums.length; i++){
                
                if(nums[i]<=ca){
                    take++;
                    i++;
                }
            }
            
            if(take>=k){
                ed=ca;
            }else{
                st=ca+1;
            }
        }
        
        return st;
    }
}