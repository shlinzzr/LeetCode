// https://leetcode.com/problems/merge-sorted-array

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        
        List<Integer> list = new ArrayList<>();
        
        int len1=nums1.length, len2=nums2.length;
        int i1=0, i2=0;
        while(i1<m && i2<len2){
            
            if(nums1[i1]<=nums2[i2]){
                list.add(nums1[i1]);
                i1++;
            }else{
                list.add(nums2[i2]);
                i2++;
            }
        }
        
        while(i1<m){
            list.add(nums1[i1]);
            i1++;
        }
        
        while(i2<len2){
            list.add(nums2[i2]);
            i2++;
        }
        
        for(int i=0; i<len1; i++){
            nums1[i] = list.get(i);
        }
        
        
        
        
    }
}