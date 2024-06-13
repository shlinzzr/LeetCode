// https://leetcode.com/problems/k-diff-pairs-in-an-array

class Solution {
    public int findPairs(int[] nums, int k) {
        int len = nums.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0)+1 );
        }
        
        int res =0;
        
        
        for(int key : map.keySet()){
            
            int val = map.get(key);
            
            if(k==0){
                if(val>=2)
                    res+=2;
                
            }else{
                if(map.containsKey(key+k)) res++; // "a find b" and "b find a" will cnt twice
                if(map.containsKey(key-k)) res++;
                
            }
            
            
        }
        
        
        return res/2;
        
        
    }
}