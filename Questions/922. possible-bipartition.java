// https://leetcode.com/problems/possible-bipartition

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {    
        Map<Integer, Set<Integer>> graph = buildGraph(dislikes, n);
        
        // for(Map.Entry<Integer, Set<Integer>> en : graph.entrySet()){
        //     System.out.println(en.getKey() + " " + en.getValue());
        // }
        
        
        UnionFind uf = new UnionFind(n);

        for(int i = 1; i < n+1; i++) {
            Set<Integer> neighbors = graph.get(i);
            if(neighbors.size() == 0) continue;
            int firstNeighbor = neighbors.iterator().next(); // gets the first item in the set

            for(int neighbor : neighbors) {
                if(uf.isConnected(i, neighbor)) return false; // if vertex i is connected with any of its neighbors, graph is not bipartite
                uf.union(firstNeighbor, neighbor); // unionize all its neighbors
            }
        }

        return true;
    }
  
    public Map<Integer, Set<Integer>> buildGraph(int[][] edges, int n) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for(int i = 1; i < n+1; i++) 
            graph.put(i, new HashSet<>());

        for(int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
  
            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }
        return graph;
    }
  
  class UnionFind {
    int[] parent;
    int[] rank;
    
    public UnionFind(int n) {
      parent = new int[n+1];
      rank = new int[n+1];
      
      for(int i = 0; i < n+1; i++) {
        parent[i] = i;
      }
    }
    
    public void union(int x, int y) {
      int rootX = find(x);
      int rootY = find(y);
      
         // System.out.println("union "+ x + ", " + y + " rx="+rootX + " ry="+rootY);
        
        
      if(rootX != rootY) {
        if(rank[rootX] > rank[rootY]) {
          rank[rootX]++;
          parent[rootY] = rootX;
        } else {
          rank[rootY]++;
          parent[rootX] = rootY;
        }
      }
        
        
//         for(int i=0; i<rank.length; i++){
//             System.out.print(rank[i] + ", ");
//         }
//         System.out.println();
        
//         for(int i=0; i<parent.length; i++){
//             System.out.print(parent[i] + ", ");
//         }
//         System.out.println();
        
        
    }
    
    public int find(int x) {
        
        // System.out.println("parent[x]="+ parent[x] + " x=" + x);
        
        if(parent[x] == x) return x;
      
        int root = find(parent[x]);
        parent[x] = root; //path compression
        return root;
    } 
    
    public boolean isConnected(int x, int y) {
        // System.out.println("isConnected "+ x + ", " + y);
        
        int fx = find(x);
        int fy = find(y);
        
        // System.out.println("findx="+fx + " findy=" + fy);
      return fx == fy;
    }
  }
}
