// https://leetcode.com/problems/peak-index-in-a-mountain-array

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        
        
        int lo = 0;
        int hi = arr.length-1;
        
        while(lo<=hi){
            
            int mid = lo + (hi-lo)/2;
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])
                return mid;
            else if( arr[mid]<arr[mid+1] )
                lo = mid;
            else
                hi = mid;
            
        }
        return lo;
    }
}