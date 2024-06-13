// https://leetcode.com/problems/total-cost-to-hire-k-workers

class Solution {
    public long totalCost(int[] costs, int k, int c) {
        int len = costs.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0]-b[0]==0 ? a[2]-b[2] : a[0]-b[0]
        );
        
        
        
        int st=0, ed=len-1;
        for( ; st<c ; st++){
            pq.offer(new int[]{costs[st], 0, st});
            
            ed = len-st-1;
            if(st<ed){
                pq.offer(new int[]{costs[ed], 1, ed});
            }
           
        }
        ed = len-st-1;
        
        
        long res =0;
        while( k>0){
            int[] p = pq.poll();
            res+=p[0];
            
            if(st<=ed){
                if( p[1]==0){
                    int[] ele = new int[]{costs[st], 0, st};
                    pq.offer(ele);
                    // System.out.println(ele[0] + " " + ele[1] + " " + ele[2]);
                    st++;
                }else{

                    int[] ele = new int[]{costs[ed], 1, ed};
                    // System.out.println(ele[0] + " " + ele[1] + " " + ele[2]);
                    pq.offer(ele);
                    ed--;
                }
            }
            
            k--;
        }
        
        return res;
    }
}