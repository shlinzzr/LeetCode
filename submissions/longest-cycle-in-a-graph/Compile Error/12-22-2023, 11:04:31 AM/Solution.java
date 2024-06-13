// https://leetcode.com/problems/longest-cycle-in-a-graph

class Solution {
    public int longestCycle(int[] edges) {
        int len = edges.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] longest = new int[len];

        Arrays.fill(longest, -1);

        for(int i=0; i<len; i++){
            HashSet<Integer> set = new HashSet<>();
            set.add(i);
            int res = dfs(i, i, edges, set, 0);
            max = Math.max(res, max);
        }

        return res;
    }

    private int dfs(int org, int cur, int[] edges, HashSet<Integer>set, int step){

        

        dfs(edge)
        
        

    }
}