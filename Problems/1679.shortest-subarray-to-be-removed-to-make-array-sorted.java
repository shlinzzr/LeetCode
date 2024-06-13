// https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted

class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int len = arr.length;
        
        
        int j =len-1;
        
        while(j>0 && arr[j-1]<=arr[j]){
            j--;
        }
        
        int min = len-1;
        
        min = Math.min(min, j);
        
        if(min==0)
            return 0;
        
        
        
        for(int i=0; i<len; i++){
            if(i-1>=0 && arr[i-1]>arr[i]){
                break;
            }
            
            while(j<len && arr[i]>arr[j]){
                j++;
            }
            
            min = Math.min(min, j-i-1);
        
        }
        
        return min;
        
        
        
        
        
    }
    
    
}