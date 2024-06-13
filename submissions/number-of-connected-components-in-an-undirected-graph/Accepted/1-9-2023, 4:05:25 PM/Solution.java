// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph

class Solution {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<n; i++){
            map.put(i, i);
        }
        int cnt=n;
        for(int[] eg : edges){ 
            int idx0 = find(eg[0], map);
            int idx1 = find(eg[1], map);
            
            if(idx0!=idx1){
                map.put(idx0, idx1);
                cnt--;
            }
            
        }
        
        return cnt;
        
//         HashMap<Integer, TreeSet<Integer>> unions = new HashMap<>();
//         for(int[] eg : edges){
//             int p = find(eg[0], map);
            
//             if(!unions.containsKey(p)){
//                 unions.put(p, new TreeSet<>());
//             }
            
//             unions.get(p).add(eg[1]);
//         }
        
//         return unions.size();   
    }
    
    
    private int find(int s, HashMap<Integer, Integer> map){
        while(map.get(s)!=s){
            
            map.put(s, map.get(map.get(s)));
            s= map.get(s);
        }
        return s;
        
    }
}