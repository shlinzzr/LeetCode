// https://leetcode.com/problems/find-eventual-safe-states

class Solution {
    
    int[] flag;
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        
        int len = graph.length;
        
        flag = new int[len];
        
        // UnionFind uf = new UnionFind(len); //第一個想法當然是uf, 但實際上有點沒法用
        
        // 其營技巧 dfs
        
        for(int i=0; i<len; i++){
            if(dfs(i, graph))
                res.add(i);
        }
        return res;
    }
    
    // flag==1 permanent safe
    // flag==2 current safe
    
    
    private boolean dfs(int i, int[][] graph){
        
        if(flag[i]==1) return true;
        if(flag[i]==2) return false;
        
        flag[i]=2;
        for(int next : graph[i]){
            if(dfs(next, graph)==false)
                return false;
        }
        flag[i]=1;
        return true;
        
        
        
    }
    
    
    class UnionFind{
        
        int[] parent;
        int[] weight;
        
        public UnionFind(int len){
            
            for(int i=0; i<len; i++){
                parent[i] = i;
                weight[i] = 1;
            }
        }
        
        public int find(int x){
            
            if(parent[x]!=x){
                parent[x] = find(parent[x]);
            }
            
            return parent[x];
        }
        
        public void union(int a, int b){
            
            a = find(a);
            b = find(b);
            
            if(a==b)
                return;
            
            if(weight[a]>=weight[b]){
                
                parent[b] = a;
                weight[a]+= weight[b];
            }else{
                parent[a] = b;
                weight[b]+= weight[a];
            }
        }
        
        
        
        
    }
}