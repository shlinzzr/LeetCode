// https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {

        int size = nums.size();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)-> a[0]-b[0]
        );

        for(int i=0; i<size; i++){
            int val = nums.get(i).get(0);
            min = Math.min(min, val);
            max = Math.max(max, val);
            pq.offer(new int[]{val, i, 0}); // val, row, col
        }


        int range = max-min;
        int st=min, ed=max;

        while(pq.size()==size){

            int[] p = pq.poll();
            min = p[0];
            int row = p[1];
            int col = p[2];

            if(max-min<range){
                range = max-min;
                st = min;
                ed = max;
            }

            if(col+1 < nums.get(row).size()){
                int val = nums.get(row).get(col+1);
                max = Math.max(max, val);
                pq.offer(new int[]{val, row, col+1});
            }
        }

        return new int[]{st, ed};





    }
}


// [4,10,15,24,26],
// [0,9,12,20],
// [5,18,22,30]

// 4
// 0 <- 9
// 5