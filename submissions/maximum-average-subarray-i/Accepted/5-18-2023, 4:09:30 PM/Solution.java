// https://leetcode.com/problems/maximum-average-subarray-i

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        int len = nums.length;
        
        double avg = -100000;
        double sum=0;
        
        int st =0;
        for(int ed=0; ed<len; ed++){
            
            sum+=nums[ed];
            if(ed-st+1<k)
                continue;
            
            avg = Math.max(avg , sum/k);
            
            sum-=nums[st++];
            
        }
        
        return avg;
        
    }
}