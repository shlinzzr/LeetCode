// https://leetcode.com/problems/escape-a-large-maze

class Solution {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        HashSet<String > blk = new HashSet<>();

        for(int[] b : blocked){
            blk.add(b[1]+"_"+b[0]);
        }

        if(blk.contains(target[1]+"_"+target[0]))
            return false;

        boolean front = helper(blk, source, target);
        boolean back = helper(blk, target, source);

        return front && back;
    }
    

    private boolean helper(HashSet<String > blk, int[] source, int[] target){

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

                if(r==target[1] && c==target[0])
                    return true;

                
                if(r<0 || c<0 || r>=1000000 || c>=1000000 || seen.contains(r+"_"+c) || blk.contains(r+"_"+c))
                    continue;

                if(Math.abs(r-y)>250 || Math.abs(c-x)>250 ){
                    // System.out.println(r+" "+ c + " " +x + " " +y);
                    return true;
                }

                seen.add(r+"_"+c);
                q.offer(new int[]{r,c});
            }
        }

        return false;

    }
}

// OOOX
// XXXX