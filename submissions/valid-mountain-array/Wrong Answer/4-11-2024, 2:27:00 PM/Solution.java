// https://leetcode.com/problems/valid-mountain-array

class Solution {
    public boolean validMountainArray(int[] arr) {
        
        int len = arr.length;
        
        
        if(len<3) return false;
        int idx= 0 ;
        
        while(idx+1 < len && arr[idx]<arr[idx+1]){
            idx++;
        }
        
        System.out.println(idx);
        
        while(idx<len-1){
            if(arr[idx]<=arr[idx+1]) return false;
            idx++;
            
        }
            
        return true;
    }
}