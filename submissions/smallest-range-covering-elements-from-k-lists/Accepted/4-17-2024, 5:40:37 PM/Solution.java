// https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {

        int size = nums.size();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>( // val, row, col
            (a,b) -> a[0]-b[0]
        );
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<size; i++){
            int val = nums.get(i).get(0);
            min = Math.min(min, val);
            max = Math.max(max, val);

            pq.offer(new int[]{val, i, 0});
        }

        int range = max-min;
        int[] res = new int[]{min, max};
        int st = min, ed=max;
        while(pq.size()==size){
            int[] p = pq.poll();
            int v = p[0];
            int r = p[1];
            int c = p[2];
            
            if(max-v < range){
                st = v;
                ed = max;
                range= ed-st;
            }

            if(c+1 < nums.get(r).size()){
                int next = nums.get(r).get(c+1);
                max = Math.max(max, next);
                pq.offer(new int[]{next, r, c+1});
            }

        }

        return new int[]{st, ed};

        
    }
}