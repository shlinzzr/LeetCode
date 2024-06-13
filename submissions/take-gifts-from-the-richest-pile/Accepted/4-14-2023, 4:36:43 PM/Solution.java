// https://leetcode.com/problems/take-gifts-from-the-richest-pile

class Solution {
    public long pickGifts(int[] gifts, int k) {
        
        int len = gifts.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(b,a)
        );
        
        for(int i=0; i<len; i++){
            pq.offer(gifts[i]);   
        }
        
        while(k>0 ){
            
            int p = pq.poll();
            
            int ele = (int)Math.sqrt(p);
            
            pq.offer(ele);
            k--;
        }
        
        long res =0L;
        
        for(int p : pq){
            res += p;
        }
        
        return res;
            
        
        
    }
}