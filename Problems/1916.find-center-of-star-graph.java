// https://leetcode.com/problems/find-center-of-star-graph

class Solution {
    public int findCenter(int[][] edges) {
        
        int len = edges.length;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        
        for(int[] edge : edges ){
            
            map.put(edge[0], map.getOrDefault(edge[0], 0)+1);
            map.put(edge[1], map.getOrDefault(edge[1], 0)+1);
        }
        
        
        int center = 0;
        for(Map.Entry<Integer, Integer> en : map.entrySet()){
            if(en.getValue()>max){
                max = en.getValue();
                center = en.getKey();
            }
                
        }
        
        return center;
    }
}