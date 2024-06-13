// https://leetcode.com/problems/most-profitable-path-in-a-tree

class Solution {
    int max = 0;
    HashMap<Integer, List<Integer>> adj;
    int bob;
    int[] amount;
    int[] b;    
    int ret;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        
        bob=bob;
        this.amount = amount;
        ret=0;
        
        int n = amount.length;
        b = new int[n];
        for (int i=0; i<n; i++)
            b[i] = Integer.MAX_VALUE/2;
        
        
        adj = new HashMap<>();
        for(int[] e: edges){
            adj.putIfAbsent(e[0], new ArrayList<>());
            adj.putIfAbsent(e[1], new ArrayList<>());
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        dfs(0, -1, 0);
        dfs2(0, -1, 0, 0);
        
        return ret;
    }
      
    private void dfs(int cur, int parent, int step)
    {
        if (cur==bob) 
        {
            b[cur] = 0;
            return;
        }
        
        int toBob = Integer.MAX_VALUE/2;
        for (int nxt: adj.get(cur))
        {
            if (nxt==parent) continue;
            dfs(nxt, cur, step+1);
            toBob = Math.min(toBob, b[nxt]+1);
        }
        b[cur] = toBob;
        return;
    }
    
    void dfs2(int cur, int parent, int step, int score)
    {
        if (step == b[cur])
            score += amount[cur]/2;
        else if (step < b[cur])
            score += amount[cur];
        
        if (adj.get(cur).size()==1 && adj.get(cur).get(0)==parent)
        {
            ret = Math.max(ret, score);
            return;
        }
                    
        for (int nxt: adj.get(cur))
        {
            if (nxt==parent) continue;
            dfs2(nxt, cur, step+1, score);          
        }
    }
}