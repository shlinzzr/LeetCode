// https://leetcode.com/problems/squirrel-simulation

class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
      

        int tx =tree[0], ty=tree[1];
        int sx =squirrel[0], sy= squirrel[1];

        int sum = 0;

        // res += Math.abs(tx-sx) + Math.abs(ty-sy);
        for(int[] nut : nuts){

            int dis = 2*(Math.abs(tx-nut[0]) + Math.abs(ty-nut[1]));
            sum += dis;
        }

        if(tx==sx && ty==sy)
            return sum;
        
        int min = Integer.MAX_VALUE;

        for(int[] nut : nuts){
            int nut2Tree = Math.abs(tx-nut[0]) + Math.abs(ty-nut[1]);
            int sql2Nut = Math.abs(sx-nut[0]) + Math.abs(sy-nut[1]);

            min = Math.min(min, sum-nut2Tree+sql2Nut);

        }

        return min;

    }
}