// https://leetcode.com/problems/minimum-interval-to-include-each-query

class Solution {

    class Inter{
        int left;
        int right;
        int size;
        public Inter(int left, int right){
            this.left=left;
            this.right=right;
            this.size = right-left+1;
        }
    }

    public int[] minInterval(int[][] intervals, int[] queries) {

          //append index in query
        int[][] queriesWithIndex = new int[queries.length][2];
        for(int i = 0; i < queries.length; i++){
            queriesWithIndex[i] = new int[]{queries[i], i};
        }
        Arrays.sort(queriesWithIndex, (a, b) -> (a[0] - b[0]));


        int len = intervals.length;
        int[] ans = new int[queries.length];
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);

        PriorityQueue<Inter> pq =new PriorityQueue<>(
            (a,b)-> a.size-b.size
        );
        int idx= 0;
        for(int j=0; j<queries.length; j++){

            int cur = queriesWithIndex[j][0];
            int queryIndex = queriesWithIndex[j][1];

            // int cur = queries[j];
            while(idx<len && intervals[idx][0]<=cur){
                pq.offer(new Inter(intervals[idx][0], intervals[idx][1]));
                idx++;
            }

            while(!pq.isEmpty() && pq.peek().right < cur){
                 pq.poll();
            }

            ans[queryIndex]= pq.isEmpty() ? -1 : pq.peek().size ;

            // if(pq.isEmpty()){
            //     ans[queryIndex] = -1;
            // }else{

            //     List<Inter> list = new ArrayList<>();
            //     while(!pq.isEmpty() && (cur < pq.peek().left || pq.peek().right<cur)){
            //         list.add(pq.poll());
            //     }
            //     if(pq.isEmpty()){
            //         ans[queryIndex] = -1;
            //     }else{
            //         ans[queryIndex] = pq.peek().size;
            //     }

            //     for(int i=0; i<list.size(); i++)
            //         pq.offer(list.get(i));
            // }
        }
        return ans;
    }
}