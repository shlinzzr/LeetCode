// https://leetcode.com/problems/permutation-sequence

class Solution {
    
    int idx=0;
    String res;
    
    public String getPermutation(int n, int k) {
        boolean[] seen = new boolean[n+1];
        
        perm(n, "", seen, k);
        
        return res;
        
    }
    
    
    private void perm(int n,  String curr, boolean[] seen, int k){
        
        if(idx>k)
            return;
        
       if(curr.length()==n) {
         
           idx++;
           if(idx==k){
               res = curr;
           }
           
           return;
       }
           
        for(int i=1; i<=n; i++){
            
            if(seen[i]==false){
                seen[i]=true;
                perm(n,  curr+i, seen, k);
                seen[i]=false;
            }
           
        }
        
    }
}