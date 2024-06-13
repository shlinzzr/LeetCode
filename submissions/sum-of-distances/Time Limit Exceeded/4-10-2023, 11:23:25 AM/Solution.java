// https://leetcode.com/problems/sum-of-distances

class Solution {
    public long[] distance(int[] nums) {
        int len = nums.length;
        long[] res = new long[len];
        
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i=0; i<len; i++){
            
            map.putIfAbsent(nums[i], new ArrayList<>());
             map.get(nums[i]).add(i);
        }
        
        
        for(Map.Entry<Integer, List<Integer>> en : map.entrySet()){
            
            int val = en.getKey();
            List<Integer> list = en.getValue();
            
            for(int i=0; i<list.size(); i++){
                
                for(int j=i+1; j<list.size(); j++){
                    
                    
                    int idx_i = list.get(i);
                    int idx_j = list.get(j);
                    
                    res[idx_i]+= Math.abs(idx_i-idx_j);
                    res[idx_j]+= Math.abs(idx_i- idx_j);
                }
            }
            
            
            
            
            
            
        }
        
        
        
        
        return res;
    }
}
