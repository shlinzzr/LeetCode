// https://leetcode.com/problems/binary-subarrays-with-sum

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
         
        int len = nums.length;
        int res = 0;
        int[] arr = new int[len+1];
        arr[0]=1;
        int psum = 0;
        for(int n: nums){
            psum += n;
            
            if(psum>=goal){
                res += arr[psum-goal];
            }
            
            arr[psum]++;
        }
        
        return res;
    }
}