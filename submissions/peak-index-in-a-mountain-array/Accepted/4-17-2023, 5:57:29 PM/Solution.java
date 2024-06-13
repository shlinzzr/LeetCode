// https://leetcode.com/problems/peak-index-in-a-mountain-array

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        
        int st = 0; 
        int ed = len-1;
        
        while(st<ed){
            
            int mid = st+(ed-st)/2;
            
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])
                return mid;
            
            else if(arr[mid]< arr[mid+1])
                st = mid;
            else 
                ed = mid;
        }
        return st;
    }
}