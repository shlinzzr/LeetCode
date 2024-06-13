// https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros

class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        int sum1=0, sum2=0;
        int z1=0, z2=0;
        for(int n : nums1){
            sum1+=n;
            if(n==0){
                z1++;
            }
        }
        
        for(int n : nums2){
            sum2+=n;
            if(n==0){
                z2++;
            }
        }
        
        
        if(sum1<=sum2 && z1==0) return -1;
        if(sum2<=sum1 && z2==0) return -1;
        if(sum1==sum2 && z1==0 && z2==0) return sum1;
        
        
        if(sum1<=sum2 && sum2-sum1<z1) return -1;
        if(sum2<=sum1 && sum1-sum2<z2) return -1;
        
        // System.out.println(sum1 + " " + z1 + " " + sum2 + " " +z2);
        return Math.max(sum1+z1, sum2+z2);
            
        
    }
}