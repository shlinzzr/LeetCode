// https://leetcode.com/problems/median-of-two-sorted-arrays

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0d;
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i=0, j=0;
        
        if(len1+len2==0)
            return 0;
        
        Integer prev = null, curr=null;
        
        while(i+j<=(len1+len2)/2){
            prev=curr;
            
            if(i<len1 && j<len2){
                if(nums1[i]<=nums2[j]){
                    curr = nums1[i];
                    i++;
                }else{
                    curr = nums2[j];
                    j++;
                }    
            }else if(i<len1){
                curr = nums1[i];
                i++;
                
            }else{
                curr = nums2[j];
                j++;
            }
            
            System.out.println(prev + " " + i + " " + j + ", "+ curr);
        }
        if((len1+len2)%2==0){
            return (Double.valueOf(prev)+Double.valueOf(curr))/2;
        }
        
        return Double.valueOf(curr);
        
    }
}

