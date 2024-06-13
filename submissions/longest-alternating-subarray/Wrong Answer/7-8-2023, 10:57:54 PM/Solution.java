// https://leetcode.com/problems/longest-alternating-subarray

class Solution {
    public int alternatingSubarray(int[] nums) {
        int len = nums.length;
        
//         int max= -1 ;
//         int cur =1;
//         int plus = nums[1] > nums[0] ? 1 : -1;
//         for(int i=0; i<len-1; i++){
            
//             if(nums[i]==nums[i+1]-1 || nums[i]==nums[i+1]+1){
//                 cur++;
//             }
            
//             plus = -plus;
//         }
        
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int i=0; i<len; i++){
            
            int n = nums[i];
            
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        
        
        
        int max= 0;
        List<Integer> list = new ArrayList<>(map.keySet());
        for(int i=0; i<list.size()-1; i++){
            
            int cur = list.get(i);
            int nxt = list.get(i+1);
            
            int min = Math.min(map.get(cur), map.get(nxt));
           
            max = Math.max(max, min);
            
        }
        
        return 2*max;
        
        
        
    }
}