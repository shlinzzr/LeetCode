// https://leetcode.com/problems/merge-sorted-array

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        
        int c=0;
        
        int n1=0, n2=0;

        while(n1<m+n&& n>0){
            
            if(n1>=m){
                
                nums1[n1] = nums2[n2];
                n1++;
                n2++;
                continue;
            }
            
            int v1 = nums1[n1];

            int v2 = nums2[n2];
            
            if(v1<=v2)
                n1++;
            else{
                int tmp = nums1[n1];
                nums1[n1] = nums2[n2];
                nums2[n2] = tmp;
                
            }
            
        }
        
        
    }
}