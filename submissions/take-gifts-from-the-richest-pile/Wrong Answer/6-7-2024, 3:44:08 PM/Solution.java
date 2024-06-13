// https://leetcode.com/problems/take-gifts-from-the-richest-pile

class Solution {
    public long pickGifts(int[] gifts, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int g : gifts){
            pq.offer(g);
        }

        while(k-->0 && !pq.isEmpty()){
            int p = pq.poll();
            pq.offer((int)Math.sqrt(p));
        }

        int sum = 0;
        for(int s: pq) {
            sum+=s;
        }

        return sum;
        
    }
}