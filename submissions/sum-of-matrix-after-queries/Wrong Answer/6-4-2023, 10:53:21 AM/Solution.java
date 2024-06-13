// https://leetcode.com/problems/sum-of-matrix-after-queries

class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        HashMap<String, int[]> map = new LinkedHashMap<>();
        
        for(int i=0; i<queries.length; i++){
            
            int[] q = queries[i];
            
            String key = q[0] + "-"+q[1];
            map.put(key, q);
        }
        
        int[][] mat = new int[n][n];
        
        
        for(Map.Entry<String, int[]> en : map.entrySet()){
            
            int[] q = en.getValue();
           
                
                for(int i=0; i<n; i++){
                    
                     if(q[0]==0){
                        mat[q[1]][i]=q[2];
                     }else{
                          mat[i][q[1]]=q[2];
                     }
                    
                }
                
        }
        
        long res=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                res += mat[i][j];
            }
        }
        
        return res;
    }
}