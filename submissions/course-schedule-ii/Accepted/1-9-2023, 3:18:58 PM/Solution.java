// https://leetcode.com/problems/course-schedule-ii

class Solution {
    public int[] findOrder(int n, int[][] prereq) {
        int[] inDeg = new int[n];
        
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        
        for(int[] pre : prereq){
            inDeg[pre[0]]++;
            
            map.putIfAbsent(pre[1], new HashSet<>());
            map.get(pre[1]).add(pre[0]);
        }
        
        int[] res = new int[n];
        boolean[] seen = new boolean[n];
        int cnt=0;
        while(cnt<n){
            
            boolean find = false;
            
            for(int i=0; i<n;i++){
                if(inDeg[i]==0 && seen[i]==false){
                    seen[i]=true;
                    find=true;
                    res[cnt++]=i;
                    Set<Integer> set = map.get(i);
                    if(set==null)
                        continue;
                    for(int s : set){
                        inDeg[s]--;
                    }
                }
            }
            
            if(find==false){
                return new int[0];
            }
            
            
        }
        
        return res;
        
        
    }
}