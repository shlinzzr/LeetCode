// https://leetcode.com/problems/valid-mountain-array

class Solution {
    public boolean validMountainArray(int[] arr) {
        
        
        int len = arr.length, st=1, ed=len-2;
        
        if(len<3) return false;
        
        while(st<ed){
            int mid = st+(ed-st)/2;
            
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return true;
            }else if(arr[mid]<arr[mid+1]){
                st = mid+1;
            }else if(arr[mid-1]> arr[mid]){
                ed = mid-1;
            }
        }
        
        if(arr[st]>arr[st-1] && arr[st]>arr[st+1]){
            return true;
        }
         
        
        
        
        return false;
        
    }
}