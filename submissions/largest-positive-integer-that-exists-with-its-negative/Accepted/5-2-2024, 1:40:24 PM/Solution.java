// https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative

class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max=Integer.MIN_VALUE;
        for(int n : nums){
            if(set.contains(-n)){
                max =Math.max(max, n);
                max =Math.max(max, -n);
            }
            set.add(n);
        }

        return max==Integer.MIN_VALUE ? -1 : max;
        
    }
}