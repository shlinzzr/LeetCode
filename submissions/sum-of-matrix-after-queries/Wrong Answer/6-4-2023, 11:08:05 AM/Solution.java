// https://leetcode.com/problems/sum-of-matrix-after-queries

class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        HashMap<Integer, Integer> rmap = new HashMap<>();
        HashMap<Integer, Integer> cmap = new HashMap<>();
        
        
        long res =0;
        for(int j=0; j<queries.length; j++){
            int[] q = queries[j];
            
            int type=q[0];
            int idx=q[1];
            int val = q[2];
            
            if(type==0){
                
                for(Map.Entry<Integer, Integer> en : cmap.entrySet()){
                     res-=en.getValue();
                }
                
                rmap.put(idx, val );
                
            }else{
                for(Map.Entry<Integer, Integer> en : rmap.entrySet()){
                    res-=en.getValue();
                    
                }
                cmap.put(idx, val);
            }
            
            res+=n*val;
            
            System.out.println(res);
        }
        
        
        // long res=0;
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<n; j++){
        //         res += mat[i][j];
        //     }
        // }
        
        return res;
    }
}