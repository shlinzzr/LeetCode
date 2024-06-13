// https://leetcode.com/problems/count-pairs-of-connectable-servers-in-a-weighted-tree-network

class Solution {
    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        
        int len = edges.length+1;
        
        int[] count= new int[len];
        
        
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        
        for(int[] e : edges){
            
            int a = e[0];
            int b = e[1];
            int w = e[2];
            
            map.putIfAbsent(a, new HashMap<>());
            map.get(a).put(b, w);
            
            map.putIfAbsent(b, new HashMap<>());
            map.get(b).put(a, w);
        }
        
        
        
        for(int c=0; c<=len; c++){
            
            
            int curr = 0;
            
            
            Set<Integer> seen = new HashSet<>();
            seen.add(c);
            
            if(map.get(c)==null || map.get(c).size()<=1) continue;
            for(int neb : map.get(c).keySet()){
                
                int cnt=0;
                
                if(map.get(c).get(neb)%signalSpeed==0)
                    cnt++;
                
                seen.add(neb);
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{neb, map.get(c).get(neb)}); // dest , weight
                
                while(q.size()>0){
                    
                    int[] pp = q.poll();
                    
                    int p = pp[0];
                    int weight = pp[1];
                    
                    for(int next : map.get(p).keySet()){
                        
                        
                        int w = map.get(p).get(next);
                        
                        if(seen.contains(next))
                            continue;
                        seen.add(next);
                        q.offer(new int[]{next, weight+w});
                        
                        if( (weight+w)%signalSpeed==0)
                            cnt++;
                    }
                }
                
                // System.out.println("neb="+neb + " cnt="+cnt);
                
                if(curr==0){
                    curr = cnt;
                }else{
                    curr*=cnt;
                }
                
                
            }
            
            count[c] = curr;
        }
        
        return count;
        
        
        
        
    
    }
}