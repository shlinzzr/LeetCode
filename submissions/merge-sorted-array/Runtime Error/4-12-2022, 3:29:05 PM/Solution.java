// https://leetcode.com/problems/merge-sorted-array

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        
        int n1=m-1, n2=n-1, fin=m+n-1;

        while(n2>=0){
            
//             while( n1<0&&n2>=0){
                
//                 nums1[fin] = nums2[n2];
//                 fin--;
//                 n2--;
//             }
            
//              while( n2<0&&n1>=0){
                
//                 nums1[fin] = nums1[n1];
//                 fin--;
//                 n1--;
//             }
            
            
//             if(fin<0)
//                 break;
//             System.out.println("fin="+fin);
//             System.out.println("n1="+n1);
//             System.out.println("n2="+n2);
            
            int v1 = nums1[n1];
            int v2 = nums2[n2];
            
            if(v2>v1){
                nums1[fin]=nums2[n2];
                fin--;
                n2--;
            
            }else {
                nums1[fin]=nums1[n1];
                fin--;
                n1--;
            }
            
        }
        
        
    }
}