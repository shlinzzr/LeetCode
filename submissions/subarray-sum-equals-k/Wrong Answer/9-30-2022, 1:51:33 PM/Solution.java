// https://leetcode.com/problems/subarray-sum-equals-k

class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int cnt=0, curr=0, st=0;
        for(int ed=0; ed<nums.length; ed++){
            curr += nums[ed];
            if(curr>k){
                while(st<nums.length -1&& curr>k){
                    curr-=nums[st];
                    st++;
                    
                }
            }
            
            if(curr==k)
                cnt++;
        }
        
        return cnt;
        
    }
}