// https://leetcode.com/problems/best-sightseeing-pair

class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        
        
        int max = 0;
        int len = values.length;
        
        for(int i=0; i<len; i++){
            
            for(int j=i+1; j<len; j++){
                max = Math.max(max, values[i]+values[j] + i-j);
            }
            
        }
        
        return max;
        
    }
}