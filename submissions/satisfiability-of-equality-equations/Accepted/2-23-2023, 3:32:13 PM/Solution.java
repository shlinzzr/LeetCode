// https://leetcode.com/problems/satisfiability-of-equality-equations

class Solution {
    
    int[] parent;
    
    public boolean equationsPossible(String[] equations) {
        int n = 26;
        Arrays.sort(equations);
        
        
        parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        
        for(String eq : equations){
            
            if(eq.charAt(1)=='!')
                continue;
            
            int root = find(parent[eq.charAt(0)-'a']);
            int node = find(parent[eq.charAt(3)-'a']);
            
            if(root!=node){
                parent[node] = root;
            }
        }
        
        
        for(String eq : equations){
            if(eq.charAt(1)=='!'){
                
                int root = find(parent[eq.charAt(0)-'a']);
                int node = find(parent[eq.charAt(3)-'a']);
                
                if(parent[node]==root)
                    return false;
            }
        }

        return true;
        
        
    }
    
    
    private int find(int x){
        if(parent[x]==x)
            return x;
        
        parent[x] = find(parent[x]);
        return parent[x];
    }
}