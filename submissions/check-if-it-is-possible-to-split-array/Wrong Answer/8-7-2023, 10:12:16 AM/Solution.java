// https://leetcode.com/problems/check-if-it-is-possible-to-split-array

class Solution {
    public boolean canSplitArray(List<Integer> nums, int m) {
        int siz = nums.size();
        
        for(int i=0; i<siz-1; i++){
            
            if(nums.get(i) + nums.get(i+1)>=m)
                return true;
        }
        
        return false;
    }
}