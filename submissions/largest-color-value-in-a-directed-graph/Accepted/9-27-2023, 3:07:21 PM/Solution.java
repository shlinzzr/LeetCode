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
            int t = helper(ch-'a', colors, edges);
            if(t==-1) return -1; // contains cycle
            ans = Math.max(ans, t);
        }
        return ans;        
    }

    private int helper(int k, String colors, int[][] edges) {

        int len = colors.length();
        int[] count = new int[len];
        int[] in = new int[len];

        System.arraycopy(inDegree, 0, in, 0, len);
        // for (int i=0; i<len; i++)
        //     in[i] = inDegree[i];
        
        int visited = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int i=0; i<len; i++)
        {
            if (in[i]==0)
            {
                visited++;
                if (colors.charAt(i)-'a'==k) count[i]++;
                q.offer(i);
            }
        }
        
        int ret = 0;
        while (!q.isEmpty())
        {
            int cur = q.poll();
            
            for (int p: g.get(cur))
            {
                count[p] = Math.max(count[p], count[cur]+ (colors.charAt(p)-'a'==k ? 1 : 0));                
                ret = Math.max(ret, count[p]);                
                in[p]--;
                if (in[p]==0)
                {                    
                    visited++;
                    q.offer(p);                 
                }
            }            
        }
        
        if (visited!=len) return -1;
        return ret;
    }
}