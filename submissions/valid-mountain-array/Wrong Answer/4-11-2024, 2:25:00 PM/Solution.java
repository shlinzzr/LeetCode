// https://leetcode.com/problems/valid-mountain-array

class Solution {
    public boolean validMountainArray(int[] arr) {
        
        int len = arr.length;
        
        int idx= 0 ;
        
        while(idx+1 < len && arr[idx]<arr[idx+1]){
            idx++;
        }
        
        while(idx<len-1){
            if(arr[idx]<arr[idx]+1) return false;
            idx++;
            
        }
            
        return true;
    }
}