// https://leetcode.com/problems/longest-harmonious-subsequence

class Solution {
    public int findLHS(int[] nums) {
        
        // TreeMap
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int n : nums){
            map.put(n , map.getOrDefault(n, 0)+1);
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        
        int max = 0;
        
        for(int i=0; i<list.size()-1; i++){
            
            int cur = list.get(i);
            int nxt = list.get(i+1);
            
            if(cur+1!=nxt)
                continue;
            
            max = Math.max(max, map.get(cur)+map.get(nxt));
        }
        
        return max;
        
        
        
        
        
        
//         Arrays.sort(nums);
//         HashMap<Integer, Integer> map = new HashMap<>();
//         int len = nums.length;
//         int max = 0;
//         for(int i=0; i<len; i++){
//             int n = nums[i];
//             if(map.containsKey(n+1)){
//                 max = Math.max(max, i-map.get(n+1)+1);
//             }
            
//             if(map.containsKey(n-1)){
//                 max = Math.max(max, i-map.get(n-1)+1);
//             }
//             if(!map.containsKey(n))
//                 map.put(n, i);
//         }
//         return max;
        
    }
}