// https://leetcode.com/problems/find-the-integer-added-to-array-i

class Solution {
    public int addedInteger(int[] nums1, int[] nums2) {
        
        int len = nums1.length;
        int sum = 0 ;
        for(int n : nums1){
            sum += n;
        }
        
        int sum2 = 0;
        
        for(int n : nums2){
            sum2+=n;
        }
        
        return (sum2 - sum)/len;
        
    }
}