// https://leetcode.com/problems/max-consecutive-ones-iii

class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int len = nums.length;

        int max=0;
        int st =0;
        int cur = 0;
        for(int i=0; i<len; i++){

            int n = nums[i];
            cur += (n==1) ? 0 : 1;


            while(cur>k){
                int v = nums[st++];
                cur -= v==0 ? 1 : 0;
            }

            max = Math.max(max, i-st+1);

        }
        return max;




    }
}