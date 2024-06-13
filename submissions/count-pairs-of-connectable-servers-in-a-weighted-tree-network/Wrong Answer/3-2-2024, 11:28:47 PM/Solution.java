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
            List<Integer> list = new ArrayList<>();
            int sum =0;
            
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
                if(cnt>0)
                    list.add(cnt);
                sum+= cnt;
                // if(curr==0){
                //     curr = cnt;
                // }else{
                //     curr*=cnt;
                // }
                
                
            }
            
            int total = 0;
            
            
            if(list.size()<2) continue;
            
            for(int r : list){
                
                total+= r* (sum-r)/2;
                
            }
            
            count[c] = total;
        }
        
        return count;
        
        
        /*
        
        Input:
[[1,0,2],[2,1,4],[3,2,4],[4,0,3],[5,1,4],[6,2,2],[7,6,4],[8,1,2],[9,8,3]]
1
Output:
[8,16,12,0,0,0,8,0,8,0]
Expected:
[8,28,20,0,0,0,8,0,8,0]

*/
        
    
    }
}