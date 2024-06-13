// https://leetcode.com/problems/minimum-height-trees

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        
        for(int i=0; i<edges.length; i++){
            map.putIfAbsent(edges[i][0], new HashSet<>());
            map.putIfAbsent(edges[i][1], new HashSet<>());
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        
        
        int min = Integer.MAX_VALUE;
        List<Integer> res = new ArrayList<>();
        
        
        for(int i=0; i<n; i++){
            boolean[] seen = new boolean[n];
            Queue<Integer> q = new LinkedList<>();    
            q.add(i);
            seen[i]=true;
            int step=1;
            
            while(!q.isEmpty()){
                
                for(int j=q.size(); j>0;j--){
                    int node = q.poll();
                    Set<Integer> set = map.get(node);
                    if(set==null)
                        continue;
                    
                    for(int nd : map.get(node)){
                        if(seen[nd]==false){
                            seen[nd]=true;
                            q.add(nd);

                        }
                    }    
                }
                
                
                
                step++;
            }
            
            
            if(step<min){
                res = new ArrayList<>();
                res.add(i);
                min = step;
            }else if(step==min){
                res.add(i);
            }
        }
        
        
        return res;
        
        
        
        
        
        
        
    }
}