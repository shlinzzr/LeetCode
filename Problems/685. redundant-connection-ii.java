// https://leetcode.com/problems/redundant-connection-ii

class Solution {
    
    Map<Integer, Integer> incoming = new HashMap<>();
    
    public int[] findRedundantDirectedConnection(int[][] a) {
        
        // count incoming edges for all nodes
        int nodeWithTwoIncomingEdges = -1;
        for(int[] v : a){
            incoming.put(v[1], incoming.getOrDefault(v[1], 0)+1);
            if(incoming.get(v[1])==2) nodeWithTwoIncomingEdges=v[1];
        }
        
        if(nodeWithTwoIncomingEdges==-1){    
            // if there are no nodes with 2 incoming edges -> just find a cycle
            return findRedundantConnection(a, -1);
        }else{
            // if there is a node with 2 incoming edges -> skip them one by one and try to build a graph
            // if we manage to build a graph without a cycle - the skipped node is what we're looking for
            for(int i=a.length-1;i>=0;i--){                           
                if(a[i][1]==nodeWithTwoIncomingEdges) {
                    int[] res = findRedundantConnection(a, i);
                    if(res==null) return a[i];
                }
            }
        }
        
        return null;
    }
    
    // 'Redundant Connection' solution is extended to skip a node.
    int[] findRedundantConnection(int[][] a, int skip){
        UnionFind uf = new UnionFind();
        
        for(int i=0;i<a.length;i++){
            if(i==skip) continue;
            if(!uf.union(a[i][0], a[i][1])) return a[i];
        } 
        
        return null;
    }
    
    class UnionFind {
        Map<Integer, Integer> map = new HashMap<>();

        int find(int x){
            if(!map.containsKey(x)) map.put(x, x);

            if(map.get(x)==x) return x;
            int par = find(map.get(x));
            map.put(x, par);
            return par;
        }

        boolean union(int x, int y){
            int px = find(x);
            int py = find(y);

            if(px==py) return false;
            map.put(px, py);
            return true;
        }        
    }
    
}