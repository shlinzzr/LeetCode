// https://leetcode.com/problems/median-of-two-sorted-arrays

// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
//         int m = nums1.length;
//         int n = nums2.length;
//         System.out.println("m="+m + ", n=" + n);
        
//         int i=0, j=0;
//         double res = 0;
        
//         while(i+j < (m+n)/2){
//             if(i<m) {
//                 res = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];
//             }else if(j<n){
//                 res = nums2[j] > nums1[i] ? nums2[j++] : nums1[i++];
//             }
//             System.out.println("res="+res + ",   i="+i + ",   j="+j );
//         }
    
//         if((m+n)%2==0){
            
            
//         }
            
    
        
//         return res;
//     }
// }

public class Solution {
    public static int[] sort(int[] ori) {
		for (int i = 0; i < ori.length; i++) {
			for (int j = i; j < ori.length; j++) {
				if (ori[i] > ori[j]) {
					int temp = ori[i];
					ori[i] = ori[j];
					ori[j] = temp;
				}
			}
		}
		return ori;
	}
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
		int len2 = nums2.length;
		int sumLen = len1 + len2;
		int[] sumArray = new int[sumLen];
		for (int i = 0; i < len1; i++) {
			sumArray[i] = nums1[i];
		}
		for (int j = 0; j < len2; j++) {
			sumArray[j + len1] = nums2[j];
		}
		for (int i = 0; i < sumArray.length; i++) {
			System.out.print(sumArray[i]);
		}
		int[] sortedArray = sort(sumArray);
		if (sumLen%2==0) {
			return (sortedArray[(sumLen/2)-1]+sortedArray[(sumLen/2)])/2.0;
		}
		else{
			return sortedArray[(sumLen/2)];
		}
    }
}