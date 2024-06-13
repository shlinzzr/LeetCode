// https://leetcode.com/problems/maximum-distance-between-a-pair-of-values

class Solution {
//     public int maxDistance(int[] nums1, int[] nums2) {
//         int len1= nums1.length;
//         int len2= nums2.length;
        
//         // i<=j, nums1[i]<=nums2[j]
        
//         for(int i=0; i<len1; i++){
            
//             for(int j=len2-1; j>=0; j--){
                
//                 int val = isValid(nums1, nums2, i, j);
                
//                 if(val!=-1){
//                     return val;
                    
//                 }else if(val>0){
                    
//                 }
//             }
//         }
//     }
    
    public int maxDistance(int[] A, int[] B) {
        int res = 0, i = 0, n = A.length, m = B.length;
        for (int j = 0; j < m; ++j) {
            while (i < n && A[i] > B[j])
                i++;
            
          
            
            if (i == n) break;
            
              System.out.println("A[" + i  + "]=" + A[i]  + " B["+ j + "]=" + B[j]);
            System.out.println("i<=j=" + (i<=j) + " A[i]<=B[j]=" +  (A[i]<=B[j]));
            System.out.println();
            
            res = Math.max(res, j - i);
        }
        return res;
    }
    
    
//     private int  isValid(int[] nums1, int[] nums2, int i , int j){
        
//         if(i>j)
//             return -1;
        
//         if(nums1[i]>nums2[j])
//             return -1;
        
//         return j-i;
        
//     }
}
