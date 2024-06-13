// https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted

class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int len = arr.length;
        
        
        if(isOk(arr, 0))
            return 0;
        
        int left =1, right=len;
        
        while(left<right){
            
            int mid = left + (right-left)/2;
            
            if( isOk(arr, mid)){
                right = mid;
                
            }else{
                left = mid+1;
            }
        }
        
        return left;
        
    }
    
    
    private boolean isOk(int[] arr, int mid){
        
        
        for(int i=0; i<arr.length-mid; i++){
            
            // [i~ i+mid-1] : ignore
            
            
            boolean flag = true;
            for(int j=0; j<arr.length-1-mid ; j++){
                
                int curr = (j>=i && j<=i+mid-1) ? j+mid : j;
                int next = (j+1>=i && j+1<=i+mid-1) ? j+1+mid : j+1;
                
                if(arr[curr]>arr[next]){
                    flag=false;
                    break;
                }
            }
            
            if(flag){
                System.out.println(i+" " + mid);
                return true;
                
            }
                
        }
        
        return false;
    }
}