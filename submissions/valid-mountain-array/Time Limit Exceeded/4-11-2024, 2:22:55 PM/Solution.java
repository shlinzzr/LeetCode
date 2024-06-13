// https://leetcode.com/problems/valid-mountain-array

class Solution {
    public boolean validMountainArray(int[] arr) {
        
        
        int len = arr.length, st=1, ed=len-2;
        
        if(len<3) return false;
        
        while(st<ed){
            int mid = st+(ed-st)/2;
            
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                if(ckm(arr, st)==false) return false;
            }else if(arr[mid]<arr[mid+1]){
                st = mid+1;
            }else if(arr[mid-1]> arr[mid]){
                ed = mid-1;
            }
        }
        
        if(ckm(arr, st)==false) return false;
        
        if(arr[st]>arr[st-1] && arr[st]>arr[st+1]){
            return true;
        }
         
        
        
        
        return false;
        
    }
    
    private boolean ckm(int[] arr, int st){
        
        int len = arr.length;
         for(int i=1; i<st; i++){
            
            if(arr[i-1]>=arr[i])return false;
            
        }
        
        for(int i=st; i<len-1; i++){
            if(arr[i]<=arr[i+1]) return false;
        }
        
        return true;
    }
}