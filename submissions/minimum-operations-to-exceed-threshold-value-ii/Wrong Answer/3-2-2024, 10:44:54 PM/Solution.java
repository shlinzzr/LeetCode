// https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii

class Solution {
    public int minOperations(int[] nums, int k) {
           
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        
        int cnt = nums.length;
        
        
        int res= 0 ;
        while(map.firstKey()<k && cnt>=2){
            
            int x = map.firstKey();
            map.put(x, map.get(x)-1);
            if(map.get(x)==0)
                map.remove(x);
            
            int y = map.firstKey();
            map.put(y, map.get(y)-1);
            if(map.get(y)==0)
                map.remove(y);
            
            int add = Math.min(x, y)*2 + Math.max(x,y);
            map.put(add, map.getOrDefault(add,0)+1);
            
            // System.out.println(x+ " " + y + " " + map.keySet());
            
//             int z = map.firstKey();
//             map.put(z, map.get(z)-1);
//             if(map.get(z)==0)
//                 map.remove(z);
            
            
            cnt-=1;
            res++;
        }
        
        
        return res;
        
    }
}