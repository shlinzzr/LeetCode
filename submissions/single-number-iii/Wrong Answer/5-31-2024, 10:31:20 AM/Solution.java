// https://leetcode.com/problems/single-number-iii

class Solution {
    public int[] singleNumber(int[] nums) {

        int len = nums.length;

        if(len==2) return nums;

        int xor = 0;

        for(int n : nums){
            xor^=n;
        }

        
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                int t = xor ^ nums[i] ^ nums[j];
                if(t==0) return new int[]{nums[i], nums[j]};
            }
        }

        return new int[2];
        
    }
}