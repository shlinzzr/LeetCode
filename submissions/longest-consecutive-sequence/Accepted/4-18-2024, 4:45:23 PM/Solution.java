// https://leetcode.com/problems/longest-consecutive-sequence

class Solution {
    public int longestConsecutive(int[] nums) {

        int len = nums.length;
        if(len==0) return 0;

        Set<Integer> set = new HashSet<>();

        for(int i=0; i<len; i++){
            set.add(nums[i]);
        }
        int max=1;

        for(int i=0; i<len; i++){
            if(set.contains(nums[i]-1)) continue;

            int cnt=0;
            int val = nums[i];
            while(set.contains(val)){
                val++;
                cnt++;
            }
            max = Math.max(max, cnt);
        }
        return max;

        
    }
}