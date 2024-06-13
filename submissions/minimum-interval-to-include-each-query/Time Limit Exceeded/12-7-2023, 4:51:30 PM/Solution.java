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


        int len = intervals.length;
        int[] ans = new int[queries.length];
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);

        PriorityQueue<Inter> pq =new PriorityQueue<>(
            (a,b)-> a.size-b.size
        );
        int idx= 0;
        for(int j=0; j<queries.length; j++){
            int cur = queries[j];
            while(idx<len && intervals[idx][0]<=cur){
                pq.offer(new Inter(intervals[idx][0], intervals[idx][1]));
                idx++;
            }

            if(pq.isEmpty()){
                ans[j] = -1;
            }else{

                List<Inter> list = new ArrayList<>();
                while(!pq.isEmpty() && (cur < pq.peek().left || pq.peek().right<cur)){
                    list.add(pq.poll());
                }
                if(pq.isEmpty()){
                  ans[j] = -1;
                }else{
                  System.out.println("j="+j + " left" + pq.peek().left);
                  ans[j] = pq.peek().size;
                }
                
                

                for(int i=0; i<list.size(); i++)
                    pq.offer(list.get(i));
            }
        }
        return ans;
    }
}