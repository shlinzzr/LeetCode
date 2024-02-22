// https://leetcode.com/problems/count-paths-that-can-form-a-palindrome-in-a-tree

class Solution {
    List<int[]>[] adj;
    Map<Integer, Integer> map = new HashMap<>();
    long  res = 0L;

    public long countPalindromePaths(List<Integer> parent, String s) {

        int n = parent.size();
        adj = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for(int i=1; i<n; i++){
            adj[parent.get(i)].add(new int[]{i, s.charAt(i)-'a'});
        }

        int state = 0 ;
        dfs(0, -1 ,state);

        return res;
    }

    private void dfs(int cur, int parent, int state){
        if(map.containsKey(state)){
            res+= map.get(state);
        }

        for(int i=0; i<26; i++){
            int s = state ^ (1<<i);
            if(map.containsKey(s)){
                res += map.get(s);
            }
        }

        map.put(state, map.getOrDefault(state,0)+1);

        for(int[] r : adj[cur]){
            if(r[0]==parent) continue;
            dfs(r[0], cur, state^(1<<(r[1])));
        }
    }

}