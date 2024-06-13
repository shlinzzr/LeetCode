// https://leetcode.com/problems/find-the-middle-index-in-array

class Solution {
    public int findMiddleIndex(int[] nums) {

        int sum = 0 ;

        int len = nums.length;

        int[] presum = new int[len];

        for(int i=0; i<len;i++){
            presum[i] = i==0 ? nums[i] : presum[i-1] + nums[i];
        }

        // x x x x x x 
        // 0
        //   i         len-1

        for(int i=0; i<nums.length; i++){   
            int left = i==0 ? 0 : presum[i-1];
            int right = i== len-1 ? 0 : presum[len-1] - presum[i];
            if(left==right) return i;
        }

        return -1;
        
    }
}