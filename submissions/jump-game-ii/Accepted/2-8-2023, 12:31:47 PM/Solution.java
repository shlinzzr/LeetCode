// https://leetcode.com/problems/jump-game-ii

class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        
        int cnt=0, far=0, end=0;
        for(int i=0; i<len-1; i++){
            
            far = Math.max(far, i+nums[i]);
            if(i==end){
                end = far;
                cnt++;
            }
            
        }
        
        return cnt;
        
        
    }
}