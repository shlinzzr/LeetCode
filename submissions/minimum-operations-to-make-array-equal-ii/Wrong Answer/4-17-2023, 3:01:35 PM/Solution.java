// https://leetcode.com/problems/minimum-operations-to-make-array-equal-ii

class Solution {
    
    
    
    public long minOperations(int[] nums1, int[] nums2, int k) {
        
        if(k==0)
            return -1;
        
        int len = nums1.length;
        
        long res = 0;
        long cnt = 0;
        for(int i=0; i<len; i++){
            
            if(Math.abs(nums1[i]- nums2[i])%k!=0)
                return -1;
            else{
                res+= Math.abs(nums1[i]-nums2[i])/k;
                cnt+= (nums1[i]-nums2[i])/k;
                
            }
        }
        
        return cnt==0 ? res/2 : -1;
        
    }
}