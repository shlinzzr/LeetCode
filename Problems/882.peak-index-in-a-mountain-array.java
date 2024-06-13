// https://leetcode.com/problems/peak-index-in-a-mountain-array

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        
        int st=1, ed=len-1;
        
        while(st<ed){ //0, 2
            int m = st+(ed-st)/2; // 1
            
            if(arr[m]>arr[m-1] && arr[m]>arr[m+1]){
                return m;
            }else if(arr[m]>arr[m-1]){
                st = m+1; //1
            }else { // arr[m-1] >= arr[m]
                ed = m-1; //0
            }
        }
        
        return st;
        
        
    }
}