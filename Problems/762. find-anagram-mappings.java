// https://leetcode.com/problems/find-anagram-mappings

class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        int len = nums1.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<len; i++){
            
            int n2 = nums2[i];
            map.put(n2, i);
        }
        
        int[] res = new int[len];
        
        for(int i=0; i<len; i++){
            
            res[i] = map.get(nums1[i]);            
        }
        
        return res;
    }
}