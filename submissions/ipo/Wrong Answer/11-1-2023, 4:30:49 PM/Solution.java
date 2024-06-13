// https://leetcode.com/problems/ipo

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int len = profits.length;
        boolean[] seen = new boolean[len];

        PriorityQueue<int[]> pq= new PriorityQueue<>( // idx, profits
            (a,b) -> b[1]-a[1]
        );

        for(int i=0; i<len; i++){
            if(w>=capital[i]){
                pq.offer(new int[]{i, profits[i]});
            }
        }

        while(!pq.isEmpty() && k-->0){

            int[] p = pq.poll();
            w+=p[1];
            seen[p[0]]=true;

            for(int i=0; i<len; i++){
                if(seen[i]==false && capital[i]>=w){
                    pq.offer(new int[]{i, profits[i]});
                }
            }

        }

        return w;

    }
}