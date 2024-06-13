// https://leetcode.com/problems/subarray-sum-equals-k

class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        
        int[] prefix = new int[len];
        
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        
        int cnt = 0;
        
        for(int i=0; i<len; i++){
            if(i==0)
                prefix[0] = nums[0];
            else {
                prefix[i] = prefix[i-1] + nums[i];
            }
                
            set.add(prefix[i]);
            
            if(set.contains(prefix[i]-k))
                cnt++;
            
        }
        
        return cnt;
    }
}