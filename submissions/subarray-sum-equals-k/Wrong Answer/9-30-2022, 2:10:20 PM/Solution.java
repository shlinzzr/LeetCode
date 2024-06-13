// https://leetcode.com/problems/subarray-sum-equals-k

class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(k, -1);
        
        int cnt=0, curr=0;
        for(int ed=0; ed<nums.length; ed++){
            curr += nums[ed];
            
            if(map.containsKey(curr+k) || map.containsKey(curr)){
                map.put(curr+k, ed);
                cnt++;
            }else{
                map.put(curr+k, ed);
            }
        }
        
        return cnt;
        
    }
}