// https://leetcode.com/problems/maximum-score-of-a-node-sequence

class Solution {


    // 每個node都只需要考慮top3 edge    

    public int maximumScore(int[] A, int[][] edges) {
           int n = A.length;
        PriorityQueue<Integer>[] q = new PriorityQueue[n];//Array of PQ
        for (int i = 0; i < n; i++)
            q[i] = new PriorityQueue<>((a, b) -> A[a] - A[b]); //Add PQ for every edge i. Sort PQ by score of edge i
        for (int[] e : edges) {
            q[e[0]].offer(e[1]); //add j to PQ of i
            q[e[1]].offer(e[0]); //add i to PQ of j
            if (q[e[0]].size() > 3) q[e[0]].poll(); //If edges are more than 3 then remove the edge with least score
            if (q[e[1]].size() > 3) q[e[1]].poll(); //If edges are more than 3 then remove the edge with least score
        }
        int res = -1;
        for (int[] edge : edges) // for every edge (a,b)
            for (int i : q[edge[0]]) // for every connecting edge with a (we are fetching this from PQ)
                for (int j : q[edge[1]])//for every connecting edge with b (we are fetching this from PQ)
                    if (i != j && i != edge[1] && j != edge[0])//if no duplicate in combo of these 4
                        res = Math.max(res, A[i] + A[j] + A[edge[0]] + A[edge[1]]);  // update the max score for this 4 combo
        return res;
    }
}