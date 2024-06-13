// https://leetcode.com/problems/minimum-common-value

class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        Integer min = null;
        
        for(int n1: nums1){
            set.add(n1);
        }
        
        for(int n2 : nums2){
            
            if(set.contains(n2)){
                
                if(min==null)
                    min = n2;
                else{
                    min = Math.min(min , n2);
                }
            }
                
            
        }
        
        return min==null ? -1:min;
        
        
    }
}