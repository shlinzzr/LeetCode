// https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-i

class Solution {
    public int minOperations(int[] nums, int k) {
        
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        
        
        int res= 0 ;
        while(map.firstKey()<k){
            
            int f = map.firstKey();
            map.put(f, map.get(f)-1);
            res++;
            if(map.get(f)==0)
                map.remove(f);
            
        }
        
        
        return res;
        
        
        
    }
}