// https://leetcode.com/problems/jump-game-ii

class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int cnt=0;
        int currFarest = nums[0];
        
        int currEnd=0;
        
        for(int i=0; i<len; i++){
            
            if(i==currEnd){
                currEnd = currFarest;
                cnt++;
                currFarest = Math.max(currFarest, i+nums[i]);
            }
        }
        
        return cnt;
        
        
    }
}