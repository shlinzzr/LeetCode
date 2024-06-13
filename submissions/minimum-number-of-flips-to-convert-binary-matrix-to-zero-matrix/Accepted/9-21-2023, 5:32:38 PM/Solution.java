// https://leetcode.com/problems/minimum-number-of-flips-to-convert-binary-matrix-to-zero-matrix

class Solution {
    public int minFlips(int[][] mat) {

        int state = 0;
        int h = mat.length;
        int w = mat[0].length;

        for (int i = 0; i < h; ++i)
            for (int j = 0; j < w; ++j)
                state |= mat[i][j] << (i * w + j); // convert the matrix to an int. 

        /*
        [1, 0]
        [0, 1] => 1001
         */

        int[][] dirs = {{1,0}, {0,1},{-1,0},{0,-1},{0,0}};

        Queue<Integer> q = new LinkedList<>(Arrays.asList(state));
        Set<Integer> seen = new HashSet<>(q);

        for (int step = 0; !q.isEmpty(); step++) {
            
            int size = q.size();
            while(size-->0){
                state = q.poll();
                if (state == 0) // All 0s matrix found.
                    return step;

                for (int i = 0; i < h; i++) { // traverse all m * n bits of cur.
                    for (int j = 0; j < w; j++) {
                        int next = state;
                        for(int[] d: dirs){
                            int r = i + d[0];
                            int c = j + d[1];
                            if (r >= 0 && r < h && c >= 0 && c < w)
                                next ^= 1 << (r * w + c);
                        }
                        if (seen.add(next)) // seen it before ?
                            q.offer(next); // no, put it into the Queue.
                    }
                }    
            }
        }
        return -1; // impossible to get all 0s matrix.
    }
}