// https://leetcode.com/problems/median-of-two-sorted-arrays

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int m = nums1.length;
        int n = nums2.length;
        System.out.println("m="+m + ", n=" + n);
        
        int i=0, j=0;
        double res = 0;
        
        while(i+j < (m+n)/2){
            if(nums1[i] <= nums2[j] && i<m) {
                res = nums1[i++];
            }else{
                res = nums2[j++];
            }
            System.out.println("res="+res + ",   i="+i + ",   j="+j );
        }
    
        if((m+n)%2==0){
            
            
        }
            
    
        
        return res;
    }
}