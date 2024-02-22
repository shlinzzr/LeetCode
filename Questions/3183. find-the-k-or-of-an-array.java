// https://leetcode.com/problems/find-the-k-or-of-an-array

class Solution {
    public int findKOr(int[] nums, int k) {
        int len = nums.length;
        int[] bit = new int[32];
        
        for(int i=0; i<len; i++){
            
            int idx = 0;
            int n = nums[i];
            while(nums[i]>0){
                bit[idx++] += nums[i]&1;
                nums[i]>>=1;
            }
        }
        
        int sum = 0;
        for(int i=0; i<32; i++){
            if(bit[i]>=k){
                sum += Math.pow(2, i);
            }
        }
        
        return sum;
        
        
    }
}