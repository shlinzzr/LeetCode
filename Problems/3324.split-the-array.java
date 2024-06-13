// https://leetcode.com/problems/split-the-array

class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
            
            if(map.get(n)>2) return false;
        }
        
        return true;
        
    }
}