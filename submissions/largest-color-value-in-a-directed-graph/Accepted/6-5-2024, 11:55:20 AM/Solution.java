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
            // and use indeg to avoid infinte loop

            ans = Math.max(ans, t);
        }
        return ans;        
    }

    private int helper(char ch, String colors, int[][] edges) {

        int len = colors.length();
        int[] count = new int[len];
        int[] indeg = Arrays.copyOf(inDegree, len);
        
        int visited = 0;
        //Queue<int[]> q = new LinkedList<>(); // => 錯的寫法
         Queue<Integer> q = new LinkedList<>(); 

        // init q
        for (int i=0; i<len; i++){
            if (indeg[i]==0){
                visited++;
                // if (colors.charAt(i)==ch)
                //     q.offer(new int[]{i, 1});
                // else 
                //     q.offer(new int[]{i, 0});  // => 錯的寫法

                if (colors.charAt(i)==ch){
                    count[i]++;
                }
                q.offer(i);
            }
        }
        
        int ret = 0;
        while (!q.isEmpty()){ 

        // bfs state 不能都存在 q 內, 可能之後的路 被帶了比較小的 state走到, 
        // let's largest assume color==2
        // 2 - 2 -1- 1- 
        // \       \
        //  0 0 0 0 0  
        // ==> 此時上面累積比較多, 但是之後的路 下面的比較慢到 卻被下面走掉了
        // 關鍵在於都是拉出來看統一的最大值, 不能放在Ｑ裡面做

            int curr = q.poll();
            
            for (int next: g.get(curr)) {

                count[next] = Math.max(count[next], count[curr]+(colors.charAt(next)==ch ? 1 : 0));                
                // int state = p[1]+(colors.charAt(next)==ch ? 1 : 0); // => 錯的寫法
                // ret = Math.max(ret, state);// => 錯的寫法
                ret = Math.max(ret, count[next]);
                indeg[next]--;
                if (indeg[next]==0) {
                    visited++;
                    q.offer(next);
                    // q.offer(new int[]{next, state});// => 錯的寫法
                }
            }            
        }
        
        if (visited!=len) return -1;
        return ret;
    }
}