// https://leetcode.com/problems/check-if-n-and-its-double-exist

class Solution {
    public boolean checkIfExist(int[] arr) {
        
        int len = arr.length;
        
        for(int i=0; i<len; i++){
            
            for(int j=i+1; j<len ; j++){
                
                if(arr[i]==arr[j]*2) return true;
                if(arr[j]==arr[i]*2) return true;
                
            }
            
        }
        
        return false;
        
    }
}