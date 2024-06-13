// https://leetcode.com/problems/corporate-flight-bookings

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] arr = new int[n+1];

        for(int[] b : bookings){
            arr[b[0]-1]+= b[2];
            arr[b[1]]-=b[2];

        }

        int[] res = new int[n];
        int cur = 0 ;
        for(int i=0; i<n; i++){
            cur += arr[i];
            res[i] = cur;
        }

        return res;
    }
}