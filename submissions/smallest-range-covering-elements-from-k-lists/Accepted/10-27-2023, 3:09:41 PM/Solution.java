// https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int size = nums.size();
        

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[2]-b[2]
        );

        int max = Integer.MIN_VALUE;

        for(int i=0; i<size; i++){
            int val = nums.get(i).get(0);
            max = Math.max(max, val);
            pq.offer(new int[]{i, 0, val});
        }

        int st=-200000, ed=max, range=200000;
        while(pq.size()==size){

            int[] p = pq.poll();
            int row = p[0];
            int col = p[1];
            int min = p[2];

            if(max-min<range){
                st = min;
                ed = max;
                range = ed-st;
            }

            if(col+1 < nums.get(row).size()){
                int next = nums.get(row).get(col+1);
                max = Math.max(max, next);
                pq.offer(new int[]{row, col+1, next});
            }
        }

        return new int[]{st,ed};
    }
}