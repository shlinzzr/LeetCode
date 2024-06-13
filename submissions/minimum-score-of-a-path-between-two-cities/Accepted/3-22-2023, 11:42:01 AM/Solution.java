// https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities

class Solution {
    
    int[] Father = new int[100005];
    public int FindFather(int x)
    {
        if (Father[x]!=x)
            Father[x] = FindFather(Father[x]);
        return Father[x];
    }
    
    public void Union(int x, int y)
    {
        x = Father[x];
        y = Father[y];
        if (x<y) Father[y] = x;
        else Father[x] = y;
    }     
    
    
    
    public int minScore(int n, int[][] roads) {
        
       for (int i=1; i<=n; i++)
            Father[i] = i;
        
       for(int[] road : roads){
            int a = road[0], b = road[1], d = road[2];
            if (FindFather(a)!=FindFather(b))
                Union(a,b);            
        }
        
        int ret = Integer.MAX_VALUE;
        for(int[] road : roads){
            int a = road[0], b = road[1], d = road[2];
            if (FindFather(a)==FindFather(1))
                ret = Math.min(ret, d);
        }
        
        return ret;
        
    }
}