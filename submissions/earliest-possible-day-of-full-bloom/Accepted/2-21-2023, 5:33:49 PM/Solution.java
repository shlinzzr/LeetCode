// https://leetcode.com/problems/earliest-possible-day-of-full-bloom

class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int len = plantTime.length;
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[1]==a[1] ? a[0]-b[1] : b[1]-a[1]
        );
        
        
        for(int i=0; i<len ;i++){
            int[] en = new int[]{plantTime[i], growTime[i]};
            pq.offer(en);
        }
        
        int total=0, max=0;
        while(pq.size()>0){
            
            int[] p = pq.poll();
            
            max = Math.max(max, total+p[0]+p[1]);
            total+= p[0];
                           
            if(pq.size()==0)
                total+=p[1];
            
            
        }
                           
                           
        return Math.max(total, max);
        
        
        
        
    }
}