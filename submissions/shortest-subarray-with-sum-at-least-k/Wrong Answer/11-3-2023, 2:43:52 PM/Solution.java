// https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int len = nums.length;

        int min = Integer.MAX_VALUE;

        int cur = 0;
        int st= 0;
        for(int ed =0; ed<len; ed++){
            cur += nums[ed];
            System.out.println(cur);
            while(st<len && (cur>=k || ed==len-1)){
                if(cur>=k)
                    min = Math.min(min, ed-st+1);

                cur-= nums[st++];
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;

    }
}