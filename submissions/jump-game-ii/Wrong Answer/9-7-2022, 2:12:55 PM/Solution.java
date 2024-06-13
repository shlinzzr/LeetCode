// https://leetcode.com/problems/jump-game-ii

class Solution {
    public int jump(int[] nums) {
        int curFarest=0, curEnd=0, cnt=0;
        for(int i=0; i<nums.length;i++){
             curFarest = Math.max(curFarest, i + nums[i]);
            
            if(curEnd==i){
                cnt++;
                curEnd = curFarest;
            }
        }
        
        
        return cnt-1;
    }
}