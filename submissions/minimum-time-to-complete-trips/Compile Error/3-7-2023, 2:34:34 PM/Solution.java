// https://leetcode.com/problems/minimum-time-to-complete-trips

class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int ans=-1;
        
        int left=1, right= 100000000000001;
        
        while(left<=right){
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
    }
}