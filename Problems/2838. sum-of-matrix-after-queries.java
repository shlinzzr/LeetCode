// https://leetcode.com/problems/sum-of-matrix-after-queries

class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        int len = queries.length;
        
        int r=n, c=n;
        
        HashSet<String> set = new HashSet<>();
        
        long sum = 0;
        
        for(int i=len-1; i>=0; i--){
            
            int[] q = queries[i];
            int type = q[0];
            int idx = q[1];
            int val = q[2];
            
            String key = type + "_" + idx;            
            if(!set.add(key))
                continue;
            
            if(type==0){
                sum+=c*val;
                r--;
            }else{
                sum+=r*val;
                c--;
            }            
            
        }
        
        return sum;
    }
}