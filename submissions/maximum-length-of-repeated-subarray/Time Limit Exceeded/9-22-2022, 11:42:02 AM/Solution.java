// https://leetcode.com/problems/maximum-length-of-repeated-subarray

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int st1=0, st2=0, len1=nums1.length, len2=nums2.length;
        
        int max = 0;
        for(int i=0; i<len1; i++){
            
            for(int j=0; j<len2; j++){
                
                for(int k=0;  k+i<len1 && k+j<len2 && nums1[i+k]==nums2[k+j]; k++){
                    
                    
                    
                    max = Math.max(k+1,max);
                    // System.out.println(" i="+i+" j="+j+" m="+max);
                }
            }
            
        }
        
        return max;
        
    }
}