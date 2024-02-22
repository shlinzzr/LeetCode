// https://leetcode.com/problems/minimum-absolute-difference-between-elements-with-constraint

class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        
        if(x==0)
            return 0;
        
        int siz = nums.size();
        
        
        int min = Integer.MAX_VALUE;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        
        
        for(int i=0;i<x; i++){
            int n = nums.get(i);
            map.put(n, map.get(n)-1);
            if(map.get(n)==0)
                map.remove(n);
        }
        
        // System.out.println(map.keySet());
        
        
        for(int i=0; i<siz-x; i++){
            
            int n = nums.get(i);
            
            Integer hi = map.ceilingKey(n);
            Integer lo = map.floorKey(n);
            
            if(hi!=null){
                min = Math.min(min, hi-n);
            }
            
            if(lo!=null)
                min = Math.min(min, n-lo);
            
            int rmval = nums.get(i+x);
            map.put(rmval, map.get(rmval)-1);
            if(map.get(rmval)==0)
                map.remove(rmval);
        }
        
        return min;
        
        
    }
}