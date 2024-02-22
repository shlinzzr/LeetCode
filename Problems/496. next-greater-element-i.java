// https://leetcode.com/problems/next-greater-element-i

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer > map = new TreeMap<>();
        
        for(int i=0 ;i<nums2.length; i++){
            map.put(nums2[i], i);
        }
        
        int[] res = new int[nums1.length];
        
        for(int i=0; i<nums1.length; i++){
            
            
            Integer key = map.get(nums1[i]);
            
            int r = -1;
            for(int st=key; st<nums2.length; st++){
                if(nums2[st]>nums1[i]){
                    r = nums2[st];
                    break;
                }
                    
            }
            
             res[i] = r;
            
        }
        
        return res;
    }
}