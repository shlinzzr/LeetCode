// https://leetcode.com/problems/minimum-time-to-complete-trips

class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        // Arrays.sort(time);
        
//         PriorityQueue<int[]> pq = new PriorityQueue<>(
//             (a, b)-> Integer.compare(a[0]+a[1], b[0]+b[1])
        
//         ); // st, cost
        
        // for(int t : time){
        //     pq.offer(new int[]{0, t});
        // }
        
        int st=1, ed=10000000;
        
        while(st<ed){
            int mid = st+(ed-st)/2;
            System.out.println(mid);
            if(isValid(time, mid, totalTrips)){
                ed=mid-1;
            }else{
                st=mid+1;
            }
        }
        
        return st;
        
        
        
//         int curr=0;
//         int trip = 0;
//         while(trip<totalTrips){
//             int[] p = pq.poll();
//             trip+=p[1];
//             curr=p[0]+p[1];
//         }
        
//         return curr;
    }
    
    
    private boolean isValid(int[] time, int idx, int totalTrips){
        
        int curr =0;
        
        for(int t : time){
            if(t<idx){
                curr+= idx/t;
                if(curr>=totalTrips)
                    return true;
            }
        }
        
        return false;
        
        
    }
}