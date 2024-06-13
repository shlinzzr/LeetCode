// https://leetcode.com/problems/best-sightseeing-pair

class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        
        
        int max_i = 0, max_j=0;
        int len = values.length;
        
        for(int i=0; i<len; i++){
            if(i!=len-1)
                max_i = Math.max(max_i, values[i]+i);
            if(i!=0)
                max_j = Math.max(max_j, values[i]-i);
            
        }
        
        return max_i+max_j;
        // 8 1 5 2 6 => 9 3 8 6 
        // 1 2 3 4 5 =>   -1 2 -2 1
    }
}