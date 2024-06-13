// https://leetcode.com/problems/longest-path-with-different-adjacent-characters

class Solution {
    int res;
    public int longestPath(int[] parent, String s) {
        res = 0;
        ArrayList<Integer>[] children = new ArrayList[parent.length];
        for (int i = 0; i < parent.length; i++)
            children[i] = new ArrayList<>();
        for (int i = 1; i < parent.length; i++)
            children[parent[i]].add(i);
        dfs(children, s, 0);
        return res;
    }

    private int dfs(ArrayList<Integer>[] children, String s, int i) {  // return the longest path to leaf
        PriorityQueue<Integer> queue = new PriorityQueue<>(
            (a,b) -> Integer.compare(b,a)
        );
        for (int j : children[i]) { // loop all children, find the longest path to leaf
            int cur = dfs(children, s, j);
            if (s.charAt(j) != s.charAt(i))
                queue.offer(cur);  // here to add "-cur" is beacause thats no need to change priorityQueue's comparator
        }
        int big1 = queue.isEmpty() ? 0 : queue.poll();
        int big2 = queue.isEmpty() ? 0 : queue.poll();
        res = Math.max(res, big1 + big2 + 1);  // check curr node whether is the longest path root
        return big1 + 1;                       // return the longer path plus self node
    }
}