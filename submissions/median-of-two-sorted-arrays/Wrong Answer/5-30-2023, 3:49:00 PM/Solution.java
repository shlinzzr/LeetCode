// https://leetcode.com/problems/median-of-two-sorted-arrays

class Solution {
    
    // https://www.youtube.com/watch?v=5hNWtR2EcrU
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        
        if ((m+n)%2==1)
            return FindKthSmallest(nums1,0,m,nums2,0,n,(m+n+1)/2);
        else
            return (FindKthSmallest(nums1,0,m,nums2,0,n,(m+n)/2)+FindKthSmallest(nums1,0,m,nums2,0,n,(m+n)/2+1))/2;
        
    }
    
    private int FindKthSmallest(int[] nums1, int a, int m, int[] nums2, int b, int n, int k){
        
        if (m>n) return FindKthSmallest(nums2,b,n,nums1,a,m,k);
        
        if (m==0) return nums2[b+k-1];
        
        if (k==1) return Math.min(nums1[a],nums2[b]);
        
        int k1=Math.min(m,k/2);
        int k2=k-k1;
        
        if (nums1[a+k1-1]<nums2[b+k2-1])
            return FindKthSmallest(nums1,a+k1,m-k1,nums2,b,n,k-k1);
        else
            return FindKthSmallest(nums1,a,n,nums2,b+k2,n-k2,k-k2);
        
        
    }
}