// https://leetcode.com/problems/smallest-missing-non-negative-integer-after-operations

class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int len = nums.length;
        
        boolean[][] bool = new boolean[value][10];
        
        for(int n : nums){
            int mod = n%value;
            if(mod<0)
                mod+=value;
            
            int i=0;
            while(i<10 && bool[mod][i]==true)
                i++;
            bool[mod][i]=true;
            
        }

        for(int i=0; i<10; i++){
            for(int j=0; j<value; j++){
                if(bool[j][i]==false)
                    return i*value+j;
            }
        }
        
        
        
        
        return value;
    }
}