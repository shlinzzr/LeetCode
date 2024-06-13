// https://leetcode.com/problems/parallel-courses-iii

class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> g = new ArrayList<>();
        for(int i=0; i<n; i++){
            g.add(new ArrayList<>());
        }



        for(int[] r : relations){
            int prev = r[0]-1;
            int next = r[1]-1;
            g.get(next).add(prev);
        }

        

        int res = 0;
        for(int i=0; i<n; i++){
            res = Math.max(res, helper(g, relations, time, i));
        }

        return res;
    }

    private int helper( List<List<Integer>> g, int[][]relations, int[] time, int cur){

        int max = 0;
        for(int next : g.get(cur)){
            max = Math.max(max, helper(g, relations, time, next));
        }

        return max + time[cur];

    }
}