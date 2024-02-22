// https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative

class Solution {
    public int findMaxK(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int n: nums){
            set.add(n);
        }
        
        List<Integer> list = new ArrayList<>(set);
        for(int i=list.size()-1; i>=0; i--){
            if(set.contains(-list.get(i)))
                return Math.abs(list.get(i));
        }
        
        return -1;
    }
}