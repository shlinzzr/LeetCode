// https://leetcode.com/problems/minimum-array-length-after-pair-removals

class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        HashMap<Integer , Integer> map = new HashMap<>();
        
        
        int max = 0;
        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0)+1);
            max = Math.max(max, map.get(n));
        }
        
        if(max > nums.size()/2){
            return max - (nums.size()-max);
        }else 
            return nums.size()%2;
        
    }
}