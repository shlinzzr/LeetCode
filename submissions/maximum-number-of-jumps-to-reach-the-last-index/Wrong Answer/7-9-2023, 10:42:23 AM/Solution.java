// https://leetcode.com/problems/maximum-number-of-jumps-to-reach-the-last-index

class Solution {
    public int maximumJumps(int[] nums, int target) {
        int len = nums.length;
        
        long cur = (long) nums[0];
        
        int cnt =0;
        for(int i=1; i<len; i++){
            int n = nums[i];
            if(Math.abs(n-cur)<=target){
                 cnt++;
                cur=n;
            }else 
                System.out.println(cur);
               
            
        }
        return cnt==0? -1 : cnt;
    }
}