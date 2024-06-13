// https://leetcode.com/problems/contains-duplicate

class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        Set<Integer> list = new HashSet<>();
        for(int n : nums)
            if(list.contains(n))
                return true;
            else 
                list.add(n);
        return false;
        
    }
}