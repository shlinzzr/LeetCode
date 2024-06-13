// https://leetcode.com/problems/median-of-two-sorted-arrays

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        
        int[] arr = merge(nums1, nums2);
        
        int l1 = nums1.length;
        int l2 = nums2.length;
        
        if((l1+l2)%2==1)
            return Double.valueOf(arr[(l1+l2)/2]);
        
        return Double.valueOf((arr[(l1+l2)/2] +arr[(l1+l2)/2-1]))/2;
        
        
    }
    
    private int[] merge(int[] nums1, int[] nums2){
        
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] res = new int[l1+l2];
        
        int i1=0, i2=0, i=0;
        
        while(i1<l1 && i2<l2){
            
            if(nums1[i1]<=nums2[i2]){
                res[i] = nums1[i1];
                i1++;
            }else{
                res[i] = nums2[i2];
                i2++;
            }
            i++;
        }
        
        while(i1<l1){
            res[i] = nums1[i1];
            i1++;
            i++;
        }
        
        while(i2<l2){
            res[i] = nums2[i2];
            i2++;
            i++;
        }
        
        return res;
    }
}