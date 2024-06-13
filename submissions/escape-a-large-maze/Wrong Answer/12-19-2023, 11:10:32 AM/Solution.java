// https://leetcode.com/problems/escape-a-large-maze

class Solution {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        HashSet<String > blk = new HashSet<>();

        for(int[] b : blocked){
            blk.add(b[0]+"_"+b[1]);
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{source[1], source[0]});
        int x = source[0];
        int y = source[1];

        if(x==target[0] && y==target[1])
            return true;

        HashSet<String> seen = new HashSet<>();
        int[][] dirs = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        while(!q.isEmpty()){
            int[] p = q.poll();

            for(int[] d : dirs){
                int r = d[0] + p[0];
                int c = d[1] + p[1];

                if(r==target[0] && c==target[1])
                    return true;

                
                if(r<0 || c<0 || r>=1000000 || c>=1000000 || seen.contains(r+"_"+c) || blk.contains(r+"_"+c))
                    continue;

                if(r>y+200 || c>x+200 || r<y-200 || c<x-200)
                    return true;

                seen.add(r+"_"+c);
                q.offer(new int[]{r,c});
            }
        }

        return false;

    }
}