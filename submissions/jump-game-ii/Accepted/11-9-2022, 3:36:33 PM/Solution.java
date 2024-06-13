// https://leetcode.com/problems/jump-game-ii

class Solution {
    public int jump(int[] nums) {
        
        int len = nums.length;
        
        int curFarest=0, curEnd=0, cnt=0;
        for(int i=0; i< len-1; i++){
            
            curFarest = Math.max(curFarest, nums[i]+i);
            
            if(i==curEnd){
                curEnd = curFarest;
                cnt++;
            }
        }
        
        return cnt;
        
    }
}