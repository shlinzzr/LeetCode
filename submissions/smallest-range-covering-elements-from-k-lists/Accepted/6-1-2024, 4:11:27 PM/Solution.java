// https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[2]-b[2]
        );

        for(int i=0; i<nums.size(); i++){
            if(nums.get(i).size()==0) return new int[2];
            min = Math.min(min, nums.get(i).get(0));
            max = Math.max(max, nums.get(i).get(0));

            pq.offer(new int[]{i, 0, nums.get(i).get(0)});
        }


        int[] res = new int[]{min, max};

        int range = max-min;
        int size = nums.size();
        while(pq.size()==size){

            int[] p = pq.poll();
            if(max-p[2]<range){
                res[0] = p[2];
                res[1] = max;
                range = max-p[2];
            }

            int r=p[0];
            int c=p[1];


            if(c+1<nums.get(r).size()){
                int val = nums.get(r).get(c+1);
                max = Math.max(max, val);
                pq.offer(new int[]{r, c+1, val});
            }
        }

        return res;
    }
}