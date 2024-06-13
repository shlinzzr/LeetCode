// https://leetcode.com/problems/merge-sorted-array

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int idx1=m-1, idx2=n-1, idxTotal = m+n-1;
        
        while(idx1>=0 && idx2>=0){
            
            if(nums1[idx1]> nums2[idx2]){
                nums1[idxTotal] =nums1[idx1];
                idx1--;
            }else{
                nums1[idxTotal] =nums2[idx2];
                idx2--;
            }
            idxTotal--;
            
            
            
        }
        while(idx2>0){
            nums1[idx2]=nums2[idx2];
            idx2--;
        }
        
        
        
        
//         int temp=Integer.MAX_VALUE, idx1=0, idx2=0;
        
//         while(idx2<n){
            
//             if(temp < nums[idx2]){
                
//                 if(nums1[idx1]<=temp){
//                     idx1++;
//                 }else{
                    
//                     temp = nums[idx1];
//                     nums[idx1] = nums[idx2];
//                     idx2++;
//                 }
                
                
//             }else{
                
//                 if(nums1[idx1]<=nums2[idx2]){
//                     idx1++;
//                 }else{
//                     temp = nums[idx1];
//                     nums[idx1] = nums[idx2];
//                     idx2++;
//                 }
                
//                 // idx1=2, idx2=1, temp = 3
            
                
//             }
            
            
//         }
    }
}