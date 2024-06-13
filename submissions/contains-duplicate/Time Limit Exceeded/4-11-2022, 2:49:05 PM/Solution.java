// https://leetcode.com/problems/contains-duplicate

class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        List<Integer> list = new ArrayList<>();
        for(int n : nums)
            if(list.contains(n))
                return true;
            else 
                list.add(n);
        return false;
        
    }
}