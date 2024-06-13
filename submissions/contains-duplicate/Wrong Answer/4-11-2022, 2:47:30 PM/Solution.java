// https://leetcode.com/problems/contains-duplicate

class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums)
            if(set.contains(n))
                return false;
        
        return true;
        
    }
}