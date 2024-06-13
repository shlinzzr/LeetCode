// https://leetcode.com/problems/contains-duplicate

class Solution {
    
    // sol.1: bf : Time O(n^2) Space(1) : TLE
    // sol.2: sorting Time O(nlgn)  Space(1) : AC
    // sol 3: HashMap Time O(n), Space(n) : AC
    
    public boolean containsDuplicate(int[] nums) {
    
        HashSet<Integer> set= new HashSet<>();
        
        for(int n: nums){
            
            if(!set.add(n))
                return true;
        }
            
        return false;
    }
    
}