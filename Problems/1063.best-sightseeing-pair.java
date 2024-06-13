// https://leetcode.com/problems/best-sightseeing-pair

class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        
        
        int max_i = 0, res=0;
        int len = values.length;
        
        for(int i=0; i<len; i++){
            
            res = Math.max(res, max_i + values[i]-i);
            
            max_i = Math.max(max_i, values[i]+i);
            
        }
        
        return res;
        // 8 1 5 2 6 => 9 3 8 6 
        // 1 2 3 4 5 =>   -1 2 -2 1
        
        
        // 2 2 2  => 3 4 5
        // 1 2 3  => 1 0 -1
    }
}