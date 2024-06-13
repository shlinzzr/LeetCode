// https://leetcode.com/problems/most-profitable-path-in-a-tree

class Solution {
   List<Integer>[] tree;
   int n;
   int[] parents;
   int[] dists;
   int[] amount;
   public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
       n = amount.length;
       this.amount = amount;
       tree = new ArrayList[n];
       for (int i = 0; i < n; i++) tree[i] = new ArrayList();
       for (int[] e : edges) {
           tree[e[0]].add(e[1]);
           tree[e[1]].add(e[0]);
       }

       parents = new int[n];
       dists = new int[n];

       // Init parents and dists
       dfs(0, 0, 0);

       // Update amounts by calculating who is closer to a node in the path
       int cur = bob;
       int bd = 0;
       while (cur != 0) {
           if (dists[cur] > bd) {
               amount[cur] = 0;
           } else if (dists[cur] == bd) {
               amount[cur] = amount[cur] / 2;
           }
           cur = parents[cur];
           bd++;
       }

       // find the max net income for Alice
       return dfs2(0);
   }

   private void dfs(int cur, int parent, int distance) {
       dists[cur] = distance;
       parents[cur] = parent;
       for (int child : tree[cur]) {
           if (child == parent) continue;
           dfs(child, cur, distance + 1);
       }
   }

   private int dfs2(int cur) {
       int max = Integer.MIN_VALUE;
       for (int child : tree[cur]) {
           if (child == parents[cur]) continue;
           max = Math.max(max, dfs2(child));
       }
       if (max == Integer.MIN_VALUE) return amount[cur];
       return max + amount[cur];
   }
}