// https://leetcode.com/problems/is-graph-bipartite

class Solution {
    public boolean isBipartite(int[][] graph) {
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        setA.add(0);
        int step=0;
        
        HashSet<Integer> seen = new HashSet<>();
        seen.add(0);
        
        while(!q.isEmpty()){
            
            int siz = q.size();  
            for(int i=0; i<siz; i++){ 
        
                int curr = q.poll(); //0
                
                for(int next : graph[curr]){
                    
                    if(step%2==1){
                        if(seen.contains(next) && setB.contains(next) )
                            return false;
                        
                        setA.add(next);
                    }else{
                        if(seen.contains(next) && setA.contains(next) )
                            return false;
                        setB.add(next);
                    }
                    
                    
                    if(seen.contains(next))
                        continue;
                    
                    q.offer(next);
                    seen.add(next);
                    
                    
                }
                
                
                
            }
            
            step++;
            
        }
        
        return true;
        
        
        
    }
}