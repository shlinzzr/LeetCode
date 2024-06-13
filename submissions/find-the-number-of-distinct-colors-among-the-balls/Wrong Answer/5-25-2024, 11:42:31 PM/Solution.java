// https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        
        int len = queries.length;
        Set<Integer> set = new HashSet<>();
        
        int[] ball = new int[limit+1];
        int[] res = new int[len];       
        for(int i =0 ;i<len ;i++){
            int x = queries[i][0];
            int y = queries[i][1];
            
            set.add(y);
            
            res[i] = set.size();
        }
        
        return res;
        
        
        
    }
}