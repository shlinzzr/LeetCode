// https://leetcode.com/problems/subarray-sum-equals-k

class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        
        int[] prefix = new int[len];
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int cnt = 0;
        int sum =0;
        
        
        for(int i=0; i<len; i++){
            
            sum += nums[i];
            
            cnt += map.getOrDefault(sum-k, 0);
            
            map.put(sum, map.getOrDefault(sum ,0)+1);
            
        }
        
        return cnt;
    }
}