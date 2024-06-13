// https://leetcode.com/problems/find-the-number-of-good-pairs-i

class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        
        int m = nums1.length;
        int n = nums2.length;
        int cnt = 0;
        
        
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(nums1[i]%(nums2[j]*k)==0)
                    cnt++;
            }
        }
        
        return cnt;
        
    }
}