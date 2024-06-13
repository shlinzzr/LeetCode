// https://leetcode.com/problems/maximize-greatness-of-an-array

class Solution {
    public int maximizeGreatness(int[] nums) {
        int len = nums.length;
        int[] perm = new int[len];
        
        Arrays.sort(nums);
        for(int i=0; i<len ; i++){
            perm[i]= nums[(i+1)%len];
        }
        
        int res= 0 ;
        for(int i=0; i<len; i++){
            
            if(perm[i]> nums[i])
                res++;
        }
        
        return res;
    }
}