// https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {

        int size = nums.size();

        PriorityQueue<int[]> pq = new PriorityQueue<>( // val, row, col
            (a,b)-> a[0]-b[0]
        );
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<size; i++){
            int val = nums.get(i).get(0);
            pq.offer(new int[]{val, i, 0});

            max = Math.max(max, val);
            min = Math.min(min, val);
        }


        int range = max-min;
        int st = min, ed = max;
        

        while(pq.size()==size){

            int[] p = pq.poll();
            int val = p[0];
            int row = p[1];
            int col = p[2];

            min = val;


            if(max-min<range){
                range = max-min;
                st = min;
                ed = max;
            }

            if(col+1<nums.get(row).size()){

                int v = nums.get(row).get(col+1);
                max = Math.max(max, v);
                pq.offer(new int[]{v, row, col+1});

               
            }
        }
        return new int[]{st, ed};

        
    }
}