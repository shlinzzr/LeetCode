// https://leetcode.com/problems/maximal-network-rank

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int len = roads.length;
        
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        
        for(int i=0; i<len; i++){
            
            int c0 = roads[i][0];
            int c1 = roads[i][1];
            
            map.putIfAbsent(c0, new HashSet<>());
            map.putIfAbsent(c1, new HashSet<>());
            
            map.get(c0).add(c1);
            map.get(c1).add(c0);
        }
        
        int max = 0;
        
        for(int i=0; i<n ; i++){
            for(int j=i+1; j<n; j++){
                
                if(map.getOrDefault(i, new HashSet<>()).contains(j)){
                    max = Math.max(max, map.get(i).size() + map.get(j).size()-1);
                }else{
                    max = Math.max(max, map.getOrDefault(i, new HashSet<>()).size() + map.getOrDefault(j, new HashSet<>()).size());
                }
            }
        }
        
        return max;
        
            
    }
}