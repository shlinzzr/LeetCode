// https://leetcode.com/problems/longest-consecutive-sequence

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int n: nums){
            set.add(n);
        }
        
        int length=0;
        int max=0;
        
        for(int i=0; i<nums.length; i++){
            
            if(!set.contains(nums[i]-1)){
                length=0;
                while(set.contains(nums[i]+length)){
                    length+=1;
                }
                max = Math.max(length, max);
            }
            
        }
        
        return max;
    }
}