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
        
       
        long left=1, right= 100000000000001L, ans=0;
         while(left<right){
            long mid= left+ (right-left)/2;  //find mid point like this to avoid overflow
            long curr_trips=0;
            for(int t: time){
                curr_trips+= mid/t;
            }
            
            if(curr_trips>=totalTrips){
                ans=mid;
                right=mid-1;
            }
            
            else{
                left=mid+1;
            }
        }
        
        return ans;        
        
        
        
        
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
            if(t<=idx){
                curr+= idx/t;
                 
            }
            if(curr>=totalTrips)
                return true;
           
        }
        
        return false;
        
        
    }
}