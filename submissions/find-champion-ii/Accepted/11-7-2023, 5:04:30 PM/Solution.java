// https://leetcode.com/problems/find-champion-ii

class Solution {
    
    public int findChampion(int n, int[][] edges) {
        
        HashMap<Integer, Integer> indegree = new HashMap<>();
        
       
        
        // UnionFind uf = new UnionFind(n);
        
        int len = edges.length;
        
        
        if(len==0){
            if(n==1)
                return 0;
            else
                return -1;
        }
        
        
        for(int i=0; i<len; i++){
            
            int src = edges[i][0];
            int dst = edges[i][1];
            
            indegree.put(dst, indegree.getOrDefault(dst,0)+1);
            
            // if(uf.find(src)!=uf.find(dst)){
            //     uf.union(src, dst);
            // }
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<n;i++){
            if(indegree.getOrDefault(i, 0)==0)
                list.add(i);
        }
        
        
        
        return list.size()==1 ? list.get(0) : -1;
            
        
        
    }
}
