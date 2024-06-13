// https://leetcode.com/problems/course-schedule-ii

class Solution {
    public int[] findOrder(int n, int[][] prereq) {
        int[] inDeg = new int[n];
        
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        
        for(int[] pre : prereq){
            
            int need = pre[1];
            int next = pre[0];
            
            inDeg[next]++;
            map.putIfAbsent(need, new HashSet<>());
            map.get(need).add(next);
        }
        
        int[] res = new int[n];
        boolean[] seen = new boolean[n];
        int cnt=0;
        while(cnt<n){
            
            boolean nextRound = false;
            
            for(int i=0; i<n;i++){
                if(inDeg[i]==0 && seen[i]==false){
                    seen[i]=true;
                    nextRound=true;
                    res[cnt++]=i;
                    Set<Integer> set = map.getOrDefault(i, new HashSet<>());
                    for(int s : set){
                        inDeg[s]--;
                    }
                }
            }
            
            if(nextRound==false){
                return new int[0];
            }
        }
        
        return res;
        
        
    }
}