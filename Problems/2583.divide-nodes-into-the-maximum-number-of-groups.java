// https://leetcode.com/problems/divide-nodes-into-the-maximum-number-of-groups

class Solution {
    public int magnificentSets(int n, int[][] edges) {
        
        UnionFind uf = new UnionFind(n);
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
            uf.merge(e[0], e[1]);
        }
        
        
        for(int i=1; i<=n; i++){
            HashSet<Integer> visited = new HashSet<>();
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            int step=0;
            
            while(!q.isEmpty()){
                
                HashSet<Integer> curr = new HashSet<>(); // this round bfs's root
                
                int siz = q.size();
                for(int j=0; j<siz; j++){

                    int p = q.poll();
                    if(visited.contains(p))
                        continue;// 已走過adjList, 不走adjList了

                    visited.add(p);
                    curr.add(p);    
                    // System.out.print(step  + " p=" + p + " : ");
                    for(int next : adj.get(p)){
                        if(curr.contains(next)) // 此次bfs parent&parent間有連通=> 死了
                            return -1;

                        if(!visited.contains(next))
                            q.offer(next);
                    }
                }
                step++;
            }
            
            
            int root = uf.find(i);
            uf.groupSize[root] = Math.max(uf.groupSize[root], step);
            
            // System.out.println(i + " root="+root + " groupSize=" + uf.groupSize[root]);
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
                // groupSize[i] = -1;
            }
        }

        public int find(int x){
            if(parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }

        public void merge(int x, int y){

            int rx = find(x), ry = find(y);

            if(rx==ry)
                return;
            
            if(weight[rx] >= weight[ry]){
                parent[ry] = parent[rx];
                weight[rx]++;
                
            } else {//if(weight[rx] < weight[ry]){
                parent[rx] = parent[ry];
                weight[ry]++;
                
            // } else { // weight[rx]<weight[ry]
            //     parent[rx] = parent[ry];
                // groupSize[ry] = Math.max(groupSize[ry],  groupSize[rx]);
                // groupSize[rx] = groupSize[ry];
            }
        }

    }
}