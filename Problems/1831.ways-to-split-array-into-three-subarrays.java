// https://leetcode.com/problems/ways-to-split-array-into-three-subarrays

class Solution {
    public int waysToSplit(int[] nums) {

        // left <= mid <= right

        int M = (int) 1e9+7;
        int len = nums.length;
        int[] presum = new int[len];
        for(int i=0; i<len; i++){
            presum[i] = i==0 ? nums[i] : nums[i] + presum[i-1];
        }
        int res = 0;
        for (int i = 0, j = 0, k = 0; i < len - 2; ++i) {
            while (j <= i || (j < len-1 && presum[j] < presum[i] * 2)) // p[j] need >= 2*p[i]
                ++j; //j 是mid.left最小的可能
            while ( k < j || ( k < len-1 && presum[k] - presum[i] <= presum[len-1] - presum[k]))
                ++k; //k 是mid.right 最大的可能

            res = (res + k - j) % 1000000007;
        }    
        return res;
    }
    // find mid.left == j
    //     [ x x x ] [ x x x] [x x x] 
    //           i     j       

    // find mid.right==k
    //     [ x x x ] [ x x x] [x x x] 
    //           i         k       len-1

}