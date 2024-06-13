// https://leetcode.com/problems/longest-consecutive-sequence

class Solution {
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        
        HashSet<Integer> set = new HashSet<>();
        for(int n: nums){
            set.add(n);
        }
        
        int max = 0;
        
        for(int i=0; i<len; i++){
            
            int n = nums[i];
            int cnt=1;
            
            if(!set.contains(n-1)){
                while(set.contains(n+1)){
                    n++;
                    cnt++;
                }
            
                max = Math.max(max, cnt);
            }
            
            
            
            
        }
        
        return max;
    }
}