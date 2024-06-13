// https://leetcode.com/problems/median-of-two-sorted-arrays

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        int idx1=0;
        int idx2=0;
        
        if(len1+len2==0)
            return 0;
        
        int curr=0;
        int prev=0;
            
        
        while(idx1+idx2<=(len1+len2)/2){

            prev= curr;
            
            if(idx1<len1 && idx2<len2){
                if(nums1[idx1]<= nums2[idx2]){
                    curr=nums1[idx1];
                    
                    idx1++;
                }else{
                    curr=nums2[idx2];
                    idx2++;

                }
                               
            }else if(idx1<len1){
                
                curr=nums1[idx1];
                idx1++;
            }else{
                
                 curr=nums2[idx2];
                idx2++;
            }
        }
        
        
        if((len1+len2)%2==0)
          return (Double.valueOf(prev)+Double.valueOf(curr))/2;
        
        
        return Double.valueOf(curr);
        
        
        
    }
}
