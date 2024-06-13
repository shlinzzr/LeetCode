// https://leetcode.com/problems/longest-cycle-in-a-graph

class Solution {
    public int longestCycle(int[] edges) {
        int len = edges.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // int[] longest = new int[len];
        // Arrays.fill(longest, -1);
        int max = -1;
        for(int i=0; i<len; i++){
            HashSet<Integer> set = new HashSet<>();
            set.add(i);
            if(edges[i]==-1) continue;

            int res = dfs(i, edges[i], edges, set, 1);
            max = Math.max(res, max);
        }

        return max;
    }

    private int dfs(int org, int cur, int[] edges, HashSet<Integer>set, int step){

        if(cur==-1) return -1;
        if(edges[cur]==-1) return -1;
        if(org==cur) return step;
        if(set.contains(cur)) return -1;
        

        set.add(cur);
        return dfs(org, edges[cur], edges, set, step+1);

        


    
        
        
        

    }
}