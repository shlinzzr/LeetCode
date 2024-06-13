// https://leetcode.com/problems/find-the-longest-equal-subarray

class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<nums.size(); i++){
            int n = nums.get(i);
            map.putIfAbsent(n, new ArrayList<>());
            map.get(n).add(i);
        }
        
        int res = 0; 
        
        for(Map.Entry<Integer, List<Integer>> en : map.entrySet()){
            
            int key = en.getKey();
            List<Integer> pos = en.getValue();
            
            
            int j=0;
            for(int i=0; i<nums.size(); i++){
                
                while(j<pos.size() && (pos.get(j)-pos.get(i)+1 - (j-i+1) )<=k){
                    res = Math.max(res, (j-i+1));
                    j++;
                }
            }
        }
        
        return res;
        
    }
}