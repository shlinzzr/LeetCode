// https://leetcode.com/problems/find-occurrences-of-an-element-in-an-array

class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        
        
        int len = queries.length;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        
        int[] res = new int[len];
        
        
        for(int i=0; i<queries.length; i++){
            
            int q = queries[i];
            
            if(map.getOrDefault(x, new ArrayList<>()).size()<q)
                res[i] = -1;
            else
                res[i] = map.get(x).get(q-1);
        }
        
        return res;
    }
}