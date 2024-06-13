// https://leetcode.com/problems/minimum-knight-moves

class Solution {
    
    HashMap<String, Integer> memo = new HashMap<>();
    
    public int minKnightMoves(int x, int y) {
        
        String key = x+","+y;        
        if(memo.containsKey(key))
            return memo.get(key);
        
        if(x+y==0)
            return 0;
        else if(x+y==2)
            return 2;
        else {
            int res = 1 + Math.min( minKnightMoves(Math.abs(x-1), Math.abs(y-2)),
                                    minKnightMoves(Math.abs(x-2), Math.abs(y-1)));
            
            memo.put(key, res);
            return res;
        }
        
    }
    
}