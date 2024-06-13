// https://leetcode.com/problems/longest-path-with-different-adjacent-characters

class Solution {

    int res= 0;

    public int longestPath(int[] parent, String s) {
        List<List<Integer>> g= new ArrayList<>();

        int n = parent.length;
        if(n==1)
            return 1;


        for(int i=0; i<n; i++)
            g.add(new ArrayList<>());
        
        for(int i=1; i<n; i++){
            int p = parent[i];
            g.get(p).add(i);
        }

        dfs(g, s, 0);
        return res;

    }


    private int dfs(List<List<Integer>> g, String s, int cur){

        int top1=0, top2=0;

        for(int child : g.get(cur)){
            if(s.charAt(child)!=s.charAt(cur)){
                int path = dfs(g, s, child);
                if(path>top1){
                    top2 = top1;
                    top1 = path;
                }else if(path>top2){
                    top2=path;
                }
            }
        }
        res = Math.max(res, 1+top1+top2);

        return 1 + top1;
    }
}