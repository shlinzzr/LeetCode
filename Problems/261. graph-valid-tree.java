// https://leetcode.com/problems/graph-valid-tree

class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int i=0; i<edges.length; i++){
            map.putIfAbsent(edges[i][0], new HashSet<>());
            map.putIfAbsent(edges[i][1], new HashSet<>());
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        
        boolean[] seen = new boolean[n];
        Queue<int[]> q = new LinkedList<>(); // parent, curr
        seen[0] = true;
        q.add(new int[]{0,0});
        
        
        while(!q.isEmpty()){
            
            int[] p = q.poll();
            int parent = p[0];
            int current = p[1];
            
            HashSet<Integer> set = map.getOrDefault(current, new HashSet<>());
            
            for(int next: set){
                if(next==parent)
                    continue;
                
                if(next==current || seen[next]==true)
                    return false;
                
                // System.out.println(Arrays.asList(p[1],s));
                
                q.offer(new int[]{current, next});
                seen[next]=true;
            }
        }
        
        for(boolean b : seen){
            if(b==false)
                return false;
        }
        
        
        return true;
    }
}