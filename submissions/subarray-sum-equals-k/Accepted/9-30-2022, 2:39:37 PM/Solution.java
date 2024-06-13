// https://leetcode.com/problems/subarray-sum-equals-k

class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int cnt=0, curr=0;
        for(int ed=0; ed<nums.length; ed++){
            curr += nums[ed];
            
            if(map.containsKey(curr-k)){
                cnt+=map.get(curr-k);
            }
            
            map.put(curr, map.getOrDefault(curr, 0)+1);
        }
        
        return cnt;
        
    }
}