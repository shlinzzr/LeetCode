// https://leetcode.com/problems/satisfiability-of-equality-equations

class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] uf = new int[26];
        for(int i=0; i<26; ++i){
            uf[i]=i;
        }
        
        for(String eq : equations){
            if('='==eq.charAt(1)){
                char a = eq.charAt(0);
                char b = eq.charAt(3);
                union(a, b, uf);    
            }
        }
        
        for(String eq : equations){
            if('!'==eq.charAt(1)){
                char a = eq.charAt(0);
                char b = eq.charAt(3);
                
                if(find(a-'a', uf)==find(b-'a', uf))
                    return false;
            }
        }
        
        return true;
        
        
    }
    
    private void union(char a, char b, int[] uf){
        uf[find(a-'a', uf)] = find(b-'a', uf);
    }
    
    private int find(int x, int[] uf){
        if(x!=uf[x]){
            uf[x] = find(uf[x], uf);
        }
        
        return uf[x];
    }
}