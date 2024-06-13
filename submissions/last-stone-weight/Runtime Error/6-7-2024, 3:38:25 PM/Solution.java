// https://leetcode.com/problems/last-stone-weight

class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int s: stones){
            pq.offer(s);
        }

        while(pq.size()>1){
            int y = pq.poll();   
            int x = pq.poll();
            

            if(x==y) continue;
            else pq.offer(y-x);
        }

        return pq.poll();
        
    }
}