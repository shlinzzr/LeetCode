// https://leetcode.com/problems/widest-pair-of-indices-with-equal-range-sum

class Solution {
    public int widestPairOfIndices(int[] nums1, int[] nums2) {
        
      
        Map<Integer, Integer> map = new HashMap<>(); // val, idx
        map.put(0, -1);
        int res = 0, sum = 0;
        for(int i = 0; i < nums1.length; i++) {
            sum += (nums1[i] - nums2[i]); // assume nums1往右走, nums2往左走
            res = Math.max(res, i - map.getOrDefault(sum, i));  // 找找看sum有沒有曾經走過了 表示nums1.rangeSum==nums2.rangeSum 
            map.putIfAbsent(sum, i);
        }
        return res;
    }
}