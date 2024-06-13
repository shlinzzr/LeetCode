// https://leetcode.com/problems/total-cost-to-hire-k-workers

class Solution {
    public long totalCost(int[] costs, int k, int c) {
        int len = costs.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0]-b[0]==0 ? a[2]-b[2] : a[0]-b[0]
        );
        
        
        
        int st=0, ed=len-1, t=c;
        while(st<ed && t>0){
            pq.offer(new int[]{costs[st], 0, st});
            st++;
            if(ed>st){
                 pq.offer(new int[]{costs[ed], 1, ed});
                ed--;
            }
            t--;
        }
        
        // System.out.println(pq.size());
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

/*
[18,64,12,21,21
,78,36,58,88,58
,99,26,92,91,53
,10,24,25,20,92
,73,63,51,65,87
,6,17,32,14,42
,46,65,43,9,75]
13
23
*/