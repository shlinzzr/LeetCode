// https://leetcode.com/problems/largest-color-value-in-a-directed-graph

class Solution {
    List<List<Integer>> g;
    int[] inDegree;

    public int largestPathValue(String colors, int[][] edges)  {
        int ans = 1;
        int len = colors.length();

        //buildMap, inDeg to find start point
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
        for (char ch='a'; ch<='z'; ch++) // assumed largest color
        {
            if(!set.add(ch)) continue;
            int t = helper(ch, colors, edges);
            if(t==-1) return -1; // contains cycle
            // how to find cycle => go throught all edge from which indeg==0,
            // cnt the visited node should equal to colors.length()
            ans = Math.max(ans, t);
        }
        return ans;        
    }

    private int helper(char ch, String colors, int[][] edges) {

        int len = colors.length();
        int[] count = new int[len];
        int[] indeg = Arrays.copyOf(inDegree, len);
        
        int visited = 0;
        Queue<int[]> q = new LinkedList<>();

        // init q
        for (int i=0; i<len; i++){
            if (indeg[i]==0){
                visited++;
                if (colors.charAt(i)==ch) 
                    q.offer(new int[]{i, 1});
                else 
                    q.offer(new int[]{i, 0});
            }
        }
        
        int ret = 0;
        while (!q.isEmpty()){

            int[] p = q.poll();
            
            for (int next: g.get(p[0])) {

                // count[next] = Math.max(count[next], count[curr]+(colors.charAt(next)==ch ? 1 : 0));                
                int state = p[1]+(colors.charAt(next)==ch ? 1 : 0);
                ret = Math.max(ret, state);                
                indeg[next]--;
                if (indeg[next]==0) {
                    visited++;
                    q.offer(new int[]{next, state});
                }
            }            
        }
        
        if (visited!=len) return -1;
        return ret;
    }
}