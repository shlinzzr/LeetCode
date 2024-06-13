// https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends

class Solution {
    public int earliestAcq(int[][] logs, int n) {
        
        Arrays.sort(logs, (a,b)-> a[0]-b[0]);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<n; i++) map.put(i, i);
        
        int res=0;
        
        for(int[] log : logs){
            int x = find(log[1], map);
            int y = find(log[2], map);
            
            if(x!=y){
                res = Math.max(res, log[0]);
                map.put(x, y);
                n--;
            }
        }
        
        return n>1 ? -1 : res;
    }
    
    private int find(int x, HashMap<Integer, Integer> map){
        
        if(map.get(x)!=x)
            map.put(x, find(map.get(x), map));
        
        return map.get(x);
        
    }
}