// https://leetcode.com/problems/binary-subarrays-with-sum

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int psum = 0, res = 0;
        
        int[] arr = new int[nums.length + 1];
        arr[0] = 1;
        
        for (int n : nums) {
            psum += n;
            
            if (psum >= goal)
                res += arr[psum - goal];
            
            arr[psum]++;
            
        }
        return res;
       
    }
}