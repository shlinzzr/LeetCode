// https://leetcode.com/problems/find-kth-largest-xor-coordinate-value

class Solution {
    public int kthLargestValue(int[][] matrix, int k) {

        int h = matrix.length;
        int w = matrix[0].length;


        PriorityQueue<Integer> pq = new PriorityQueue<>(
            // Collections.reverseOrder()
        );
        int[][] prexor = new int[h][w];
        int res = 0 ;
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){

                prexor[i][j] = matrix[i][j];

                if(i>0) prexor[i][j] ^= prexor[i-1][j];
                if(j>0) prexor[i][j] ^= prexor[i][j-1];
                if(i>0 && j>0) prexor[i][j] ^= prexor[i-1][j-1];
                pq.offer(prexor[i][j]);

                if(pq.size()>k)
                    pq.poll();
            }
        }

// 5 : 0101
// 4 : 0100
// 7 : 0111
// 6 : 0110
// a : 0101 


//  5 2
//  1 6

//  5 7
//  4 5

        return pq.peek();


        // return res;
    }
}