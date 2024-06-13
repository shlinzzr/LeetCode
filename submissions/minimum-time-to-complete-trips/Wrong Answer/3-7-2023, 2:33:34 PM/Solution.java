// https://leetcode.com/problems/minimum-time-to-complete-trips

class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int ans=-1;
        
        int left=1, right= 10000000;
        
        while(left<=right){
            int mid= left+ (right-left)/2;  //find mid point like this to avoid overflow
            int curr=0;
            for(int t: time){
                curr+= mid/t;
            }
            
            if(curr>=totalTrips){
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