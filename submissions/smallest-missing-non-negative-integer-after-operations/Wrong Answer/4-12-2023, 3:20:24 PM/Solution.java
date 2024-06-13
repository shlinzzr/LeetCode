// https://leetcode.com/problems/smallest-missing-non-negative-integer-after-operations

class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int len = nums.length;
        
        boolean[] bool = new boolean[value];
        
        for(int n : nums){
            int mod = n%value;
            if(mod<0)
                mod+=value;
            bool[mod]=true;
        }

        for(int i=0; i<value; i++){
            if(bool[i]==false)
                return i;
        }
        
        
        return value;
    }
}