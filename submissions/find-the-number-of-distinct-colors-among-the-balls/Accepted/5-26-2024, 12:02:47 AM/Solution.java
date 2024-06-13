// https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        
        int len = queries.length;
        Map<Integer, Integer> map = new HashMap<>(); // color cnt
        
        // int[] ball = new int[limit+1];
        Map<Integer, Integer> ball = new HashMap<>();
        
        
        
        int cnt=0;
        int[] res = new int[len];       
        for(int i =0 ;i<len ;i++){
            int x = queries[i][0];
            int y = queries[i][1];
            
            
            if(!ball.containsKey(x)){
            
                if(!map.containsKey(y)){
                    map.put(y, 1);
                    
                    
                }else{
                    map.put(y, map.getOrDefault(y, 0)+1);
                }
            }else{
                
                
                int cur = ball.get(x);
                
                map.put(cur, map.get(cur)-1);
                if(map.get(cur)==0)
                    map.remove(cur);
                        
                map.put(y, map.getOrDefault(y, 0)+1);
                
            }
            
            ball.put(x, y);
            
            
            res[i] = map.size();
        }
        
        return res;
        
        
        
    }
}