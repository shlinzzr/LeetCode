// https://leetcode.com/problems/largest-color-value-in-a-directed-graph

class Solution {
    List<List<Integer>> g;
    int[] inDegree;

    public int largestPathValue(String colors, int[][] edges)  {
        int ans = 1;
        int len = colors.length();
        inDegree = new int[len];
        g = new ArrayList<>();
        for(int i=0; i<len; i++){
            g.add(new ArrayList<>());
        }

        for (int[] edge: edges){
            int src = edge[0];
            int dst = edge[1];
            g.get(src).add(dst);
            inDegree[dst]++;
        }
        
        Set<Character> set = new HashSet<>();
        for (char ch='a'; ch<='z'; ch++)
        {
            if(!set.add(ch)) continue;
            int t = helper(ch, colors, edges);
            if(t==-1) return -1; // contains cycle
            ans = Math.max(ans, t);
        }
        return ans;        
    }

    private int helper(char ch, String colors, int[][] edges) {

        int len = colors.length();
        int[] count = new int[len];
        int[] in = new int[len];

        for (int i=0; i<len; i++)
            in[i] = inDegree[i];
        
        int visited = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int i=0; i<len; i++)
        {
            if (in[i]==0)
            {
                visited++;
                if (colors.charAt(i)==ch) 
                    count[i]++;
                q.offer(i);
            }
        }
        
        int ret = 0;
        while (!q.isEmpty())
        {
            int cur = q.poll();
            
            for (int nxt: g.get(cur))
            {
                count[nxt] = Math.max(count[nxt], count[cur]+ (colors.charAt(nxt)==ch ? 1 : 0));                
                ret = Math.max(ret, count[nxt]);                
                in[nxt]--;
                if (in[nxt]==0)
                {                    
                    visited++;
                    q.offer(nxt);                 
                }
            }            
        }
        
        if (visited!=len) return -1;
        return ret;
    }
}