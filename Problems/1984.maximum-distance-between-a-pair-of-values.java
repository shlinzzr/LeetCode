// https://leetcode.com/problems/maximum-distance-between-a-pair-of-values

class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int ans = 0;

        int len1 = nums1.length, len2 = nums2.length;
        int i = 0, j = 0;

        while(i < len1 && j < len2){
            if(nums1[i] <= nums2[j]){
                ans  = Math.max(ans, j - i);
                j++;
            } else {
                i++;
            }
        }
        return ans;
    }
}
