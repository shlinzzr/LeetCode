// https://leetcode.com/problems/longest-consecutive-sequence

class Solution {
    public int longestConsecutive(int[] nums) {
        
        
        Set<Integer> set = new HashSet<>();
        for(int n: nums){
            set.add(n);
        }
        
        int max = 0;
        for(int s : set){
            if(!set.contains(s-1)){
                int cnt =1;
                int curr = s+1;
                while(set.contains(curr)){
                    cnt++;
                    curr++;
                }
                max = Math.max(max, cnt);
                
            }
        }
        
        return max;
        
    }
}