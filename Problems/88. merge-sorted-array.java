// https://leetcode.com/problems/merge-sorted-array

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
      
        int i=0, j=0;
        
        List<Integer> list = new ArrayList<>();
        while(i<m || j<n){
            
            if(i<m && j<n){
                if( nums1[i]<= nums2[j]){
                    list.add(nums1[i]);
                    i++;
                }else{
                    list.add(nums2[j]);
                    j++;
                }

            }
            
            else if(i<m){
                list.add(nums1[i]);
                i++;
            }else{
                list.add(nums2[j++]);
            }
        }
        
        for(int k=0; k<m+n; k++){
            nums1[k] = list.get(k);
        }
        
    }
}