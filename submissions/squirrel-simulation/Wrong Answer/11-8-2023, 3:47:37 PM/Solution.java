// https://leetcode.com/problems/squirrel-simulation

class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0] -b[0]
        );

        int res = 0;

        int tx =tree[0], ty=tree[1];
        int sx =squirrel[0], sy= squirrel[1];


        // res += Math.abs(tx-sx) + Math.abs(ty-sy);
        for(int[] nut : nuts){

            int dis = 2*(Math.abs(tx-nut[0]) + Math.abs(ty-nut[1]));

            pq.offer(new int[]{Math.abs(tx-nut[0]) + Math.abs(ty-nut[1]) + Math.abs(sx-nut[0]) + Math.abs(sy-nut[1]), dis });

            res+= dis;
        }

        int[] p = pq.poll();

        res+=p[0];
        res-=p[1];

        return res;


    }
}