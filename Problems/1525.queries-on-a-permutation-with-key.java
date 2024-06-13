// https://leetcode.com/problems/queries-on-a-permutation-with-key

class Solution {
    public int[] processQueries(int[] queries, int m) {

        int[] res =new int[queries.length];
        
        List<Integer> p = new ArrayList<>();
        for(int i=0; i<m; i++){
            p.add(i+1);
        }
        
        for(int j=0; j<queries.length; j++){
            
            int q = queries[j];
            
            for(int i=0; i<p.size(); i++){
                
                int pval = p.get(i);
                if(q==pval){
                    p.remove(i);
                    p.add(0, pval);
                    
                    res[j] = i;
                    break;
                    
                }
            }
            
            
        }
        
        return res;
    }
}
            
            
