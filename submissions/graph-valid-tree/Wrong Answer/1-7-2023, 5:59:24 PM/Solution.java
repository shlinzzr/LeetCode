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
        Queue<int[]> q = new LinkedList<>();
        seen[0] = true;
        q.add(new int[]{0,0});
        
        
        while(!q.isEmpty()){
            
            int[] p = q.poll();
            
            HashSet<Integer> set = map.get(p[1]);
            if(set==null)
                continue;
            
            for(int s: set){
                if(s==p[0] && p[0]!=0)
                    continue;
                
                if(s!=p[1] && seen[s]==true)
                    return false;
                
                System.out.println(Arrays.asList(p[1],s));
                
                q.offer(new int[]{p[1], s});
                seen[s]=true;
            }
        }
        
        return true;
    }
}