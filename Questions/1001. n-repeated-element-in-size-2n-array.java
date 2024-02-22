// https://leetcode.com/problems/n-repeated-element-in-size-2n-array

class Solution {
    public int repeatedNTimes(int[] nums) {
          Set<Integer> set = new HashSet<>();
        for(int n: nums){
            if(!set.add(n)) return n;
        }
        return 0;
    }
}