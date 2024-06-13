// https://leetcode.com/problems/longest-consecutive-sequence

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int n: nums){
            set.add(n);
        }
        
        int max=0;
        
        for(int i=0; i<nums.length; i++){
            
            if(!set.contains(nums[i]-1)){
                int cnt=0;
                while(set.contains(nums[i]+length)){
                    cnt++;
                }
                max = Math.max(cnt, max);
            }
            
        }
        
        return max;
    }
}