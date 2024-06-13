// https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label

class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
     
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        
        for(int i=0; i<n; i++) map.put(i, new ArrayList<>());
            
        for(int[] e : edges){
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        
        boolean[] seen = new boolean[n];
        
        int[] res = new int[n];
      
        dfs(map, 0, labels,  res, seen);
        
        return res;
    }
    
     private int[] dfs(Map<Integer, List<Integer>> map, int node, String labels, int[] res, boolean[] seen) {  
         int[] cnt = new int[26];
         
         if(seen[node])
             return cnt;
         
         seen[node] = true;
         
         
         char ch = labels.charAt(node);
         for(int child : map.get(node)){
             int[] sub = dfs(map, child, labels, res, seen);
             for(int i=0; i<26; i++){
                 cnt[i]+=sub[i];
             }
         }
         cnt[ch-'a']++;
         res[node]=cnt[ch-'a'];
         
         return cnt;
        
    }
}