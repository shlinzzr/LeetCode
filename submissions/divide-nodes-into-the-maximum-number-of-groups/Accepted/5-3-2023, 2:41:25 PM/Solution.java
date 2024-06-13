// https://leetcode.com/problems/divide-nodes-into-the-maximum-number-of-groups

class Solution {
    public int magnificentSets(int n, int[][] edges) {
        
        
        UnionFind uf = new UnionFind(n);
        
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i <= n; i++) 
            adjList.add(new ArrayList<>());

        for(int [] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
            uf.merge(edge[0], edge[1]);
        }

        for(int i = 1; i <= n; i++){
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            
            Set<Integer> visited = new HashSet<>();
            int counter = 0;
            while(!q.isEmpty()){
                int size = q.size();
                Set<Integer> inQueue = new HashSet<>();
                
                for(int j = 0; j < size; j++){
                    int p = q.poll();
                    if(visited.contains(p)) 
                        continue;
                    
                    inQueue.add(p);
                    visited.add(p);
                    
                    for(int neighbor : adjList.get(p)){
                        if(inQueue.contains(neighbor)){
                            return -1;
                        }
                        if(!visited.contains(neighbor))
                            q.add(neighbor);
                    }
                }
                counter++;
            }
            int root = uf.find(i);
            uf.groupSize[root] = Math.max(uf.groupSize[root], counter);

        }
        Set<Integer> done = new HashSet<>();
        int result = 0;
        for(int i = 1; i <= n; i++) {
            int root = uf.find(i);
            if(done.contains(root)) 
                continue;
            done.add(root);
            result += uf.groupSize[root];
        }
        return result;

    }

    class UnionFind {
        int [] parent, groupSize, weight;

        public UnionFind(int n){
            this.parent = new int [n+1];
            this.groupSize = new int [n+1];
            this.weight = new int [n+1];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                groupSize[i] = -1;
            }
        }

        public int find(int x){
            if(parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }

        public void merge(int x, int y){

            int rx = find(x), ry = find(y);

            if(weight[rx] == weight[ry]){
                parent[rx] = parent[ry];
                weight[ry]++;
            } else if(weight[rx] > weight[ry]){
                parent[ry] = parent[rx];
            } else parent[rx] = parent[ry];

            groupSize[ry] = Math.max(groupSize[ry],  groupSize[rx]);
            groupSize[rx] = groupSize[ry];
        }

    }
    
}