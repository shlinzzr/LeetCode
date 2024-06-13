// https://leetcode.com/problems/largest-color-value-in-a-directed-graph

class Solution {
    int[] inDegree;

    HashMap<Integer, List<Integer>> map ;
    public int largestPathValue(String colors, int[][] edges) {
        int ans = 1;
        inDegree = new int[100000];
        map = new HashMap<>();

        for (int[] edge: edges)
        {            
            int a = edge[0], b = edge[1];
            map.putIfAbsent(a, new ArrayList<>());
            map.get(a).add(b);
            inDegree[b]++;
        }
        
        HashSet<Character> set = new HashSet<>();
        for (char ch='a'; ch<='z'; ch++)
        {
            if (!set.contains(ch)) continue;
            int t = helper(ch-'a', colors, edges);
            if(t==-1) return -1;
            ans = Math.max(ans, t);
        }
        return ans;        
    }


    private int helper(int k, String colors, int[][] edges){
        int n = colors.length();

        int[] count = new int[n];
        int[] in = new int[n];

        for (int i=0; i<n; i++)
            in[i] = inDegree[i];
        
        int nodes = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<n; i++)
        {
            if (in[i]==0)
            {
                nodes++;
                if (colors.charAt(i)-'a'==k) count[i]++;
                q.offer(i);
            }
        }
        
        int ret = 0;
        while (!q.isEmpty())
        {
            int cur = q.poll();
            
            for (int p: map.get(cur))
            {
                count[p] = Math.max(count[p], count[cur]+ (colors.charAt(p)-'a'==k ? 1 : 0));                
                ret = Math.max(ret, count[p]);
                in[p]--;
                if (in[p]==0)
                {                    
                    nodes++;
                    q.offer(p);                 
                }
            }            
        }
        
        if (nodes!=n) return -1;
        return ret;
    }
}