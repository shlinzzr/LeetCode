// https://leetcode.com/problems/smallest-missing-non-negative-integer-after-operations

class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int len = nums.length;
        
        int[] bool = new int[value];
        
        for(int n : nums){
            int mod = n%value;
            if(mod<0)
                mod+=value;
            bool[mod]++;
            
        }

        int stop = 0;
        
        for(int j=0; j<value; j++){

            if(bool[j]<bool[stop])
                stop=j;
        }
        
        return value*bool[stop] + stop;
        
        
    }
}