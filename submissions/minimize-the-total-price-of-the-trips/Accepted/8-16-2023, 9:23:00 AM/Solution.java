// https://leetcode.com/problems/minimize-the-total-price-of-the-trips

class Solution {

    // recur + memo, OR dp
    List<Integer>[] next = new ArrayList[55];
    int[] plan0 = new int[55];
    int[] plan1 = new int[55];
    int[] count = new int[55];
    int[] val = new int[55];
    
    
    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        
        // Arrays.fill(next, new ArrayList<>());
        
        for (int[] e: edges)
        {
            int a = e[0], b = e[1];
            
            if(next[a]==null)
                next[a] = new ArrayList<>();
            
            if(next[b]==null)
                next[b] = new ArrayList<>();
            
            next[a].add(b);
            next[b].add(a);
        }
        
        Arrays.fill(plan0, -1);
        Arrays.fill(plan1, -1);
        
        
        for (int[] trip: trips)
        {
            dfs(trip[0], -1, trip[1]);
        }
        
        for (int i=0; i<n; i++)
        {
            val[i] = price[i]*count[i];
        }
        
        return DFS(0, -1, 1); 
    }
    
    private boolean dfs(int cur, int parent, int target)
    {        
        if (cur==target) 
        {
            count[cur]++;
            return true;
        }            
        if(next[cur]!=null){
            for (int x: next[cur])
            {
                if (x==parent) continue;
                if (dfs(x, cur, target))
                {
                    count[cur]++;
                    return true;                
                }                
            }
        }
        
        return false;
    }
    
    private int DFS(int node, int parent, int flag)  // flag = 1 : can choose;  flag = 0 : cannot choose 
    {                
        if (flag==0 && plan0[node]!=-1) return plan0[node];
        if (flag==1 && plan1[node]!=-1) return plan1[node];        
                
        if (flag==0)
        {
            int ret = val[node]; //自己不能半價
            if(next[node]!=null){
                for (int x: next[node])
                {
                    if (x==parent) continue;
                    ret += DFS(x, node, 1); //adj可以半價
                }        
            }
            plan0[node] = ret;
            return ret;
        }
        else
        {
            int ret = Integer.MAX_VALUE;
            
            int option1 = val[node]/2; //自己選擇半價
            if(next[node]!=null){
                for (int x: next[node])
                {
                    if (x==parent) continue;
                    option1 += DFS(x, node, 0); // adj不給半價
                }
            }
                
            
            int option2 = val[node]; // 自己可以但沒選半價
            if(next[node]!=null){
                for (int x: next[node])
                {
                    if (x==parent) continue;
                    option2 += DFS(x, node, 1); //adj可以半價
                }
            }
                        
            ret = Math.min(option1, option2);
            plan1[node] = ret;
            return ret;
        }                
        
    }
}
