// https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int i1=0, i2=0;
        int len1= nums1.length;
        int len2= nums2.length;
        
        List<int[]> list = new ArrayList<>();
        while(i1<len1 && i2<len2){
            int sum = 0;
            
            if(nums1[i1][0]==nums2[i2][0]){
                sum = nums1[i1][1]+nums2[i2][1];
                list.add(new int[]{nums1[i1][0], sum});
                i1++;
                i2++;
                
            }else if(nums1[i1][0]<nums2[i2][0]){
                sum = nums1[i1][1];
                list.add(new int[]{nums1[i1][0], sum});
                i1++;
                
                
            }else{
                sum = nums2[i2][1];
                list.add(new int[]{nums2[i2][0], sum});
                i2++;
            }
        }
        
        while(i1<len1){
            list.add(new int[]{nums1[i1][0], nums1[i1][1]});
        }
        
        while(i2<len2){
            list.add(new int[]{nums2[i2][0], nums2[i2][1]});
        }
        
        int[][] res = new int[list.size()][];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }
        
        return res;
        
    }
}