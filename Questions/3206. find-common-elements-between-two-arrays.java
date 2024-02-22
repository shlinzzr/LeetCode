// https://leetcode.com/problems/find-common-elements-between-two-arrays

class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
         HashMap<Integer, Integer> map2 = new HashMap<>();
        
        for(int n: nums1){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        int a1=0;
        for(int n : nums2){
            if(map.containsKey(n)){
                a1++;
            }
            
            map2.put(n, map2.getOrDefault(n,0)+1);
            
        }
        int a2=0;
        for(int n : nums1){
            if(map2.containsKey(n))
                a2++;
        }
        
        return new int[]{a2,a1};
    }
}