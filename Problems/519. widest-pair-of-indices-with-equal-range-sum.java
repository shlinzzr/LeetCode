// https://leetcode.com/problems/widest-pair-of-indices-with-equal-range-sum

class Solution {
    public int widestPairOfIndices(int[] nums1, int[] nums2) {
        
//         int len1 = nums1.length;
//         int len2 = nums2.length;
        
//         int[] presum1 = new int[len1];
//         int[] presum2 = new int[len2];
        
//         for(int i=0; i<len1; i++){
//             presum1+= i==0? nums1[0] : presum1[i-1] + nums1[i];
//         }
        
//         for(int i=0; i<len2; i++){
//             presum2+= i==0? nums2[0] : presum2[i-1] + nums2[i];
//         }
        
//         for(int i=0; i<len1; i++){
//         }
        
        Map<Integer, Integer> map = new HashMap<>(); // val, idx
        map.put(0, -1);
        int result = 0, sum = 0;
        for(int i = 0; i < nums1.length; i++) {
            sum += (nums1[i] - nums2[i]); // assume nums1往右走, nums2往左走
            result = Math.max(result, i - map.getOrDefault(sum, i));  // 找找看sum有沒有曾經走過了 表示nums1.rangeSum==nums2.rangeSum 
            map.putIfAbsent(sum, i);
        }
        return result;
        
        
    }
}