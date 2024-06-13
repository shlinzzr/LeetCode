// https://leetcode.com/problems/find-anagram-mappings

class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        int len = nums2.length;
        for(int i=0; i<len; i++){
            int n = nums2[i];
            
            map.putIfAbsent(n, new ArrayList<>());
            map.get(n).add(i);
        }
        
        int[] res = new int[len];
        for(int i=0; i<len; i++){
            
            int n = nums1[i];
            res[i] = map.get(n).get(0);
            map.get(n).remove(0);
        }
        return res;
            
        
    }
}