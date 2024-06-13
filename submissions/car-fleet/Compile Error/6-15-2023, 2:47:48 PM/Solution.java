// https://leetcode.com/problems/car-fleet

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = speed.length;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<len; i++){
            map.put(position[i], 1);
        }
        
        int cnt = 0, res=0;
        
        
        while(cnt<len){
            
            Map<Integer, Integer> newMap = new TreeMap<>();
            
            
            for(int i=0; i<len; i++){
                
                if(map.higherKey()<)
                
                
                
            }
            
            
            
            
            
        }
        
    }
}