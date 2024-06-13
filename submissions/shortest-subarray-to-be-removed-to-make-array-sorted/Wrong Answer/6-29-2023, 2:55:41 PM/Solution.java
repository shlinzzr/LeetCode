// https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted

class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int len = arr.length;
        
        
        if(isOk(arr, 0))
            return 0;
        
        int left =1, right=len;
        
        while(left<right){
            
            int mid = left + (right-left)/2;
            
            System.out.println("l="+left + " r=" + right + " m=" + mid);
            
            boolean bool =  isOk(arr, mid);
            
            
            
            
            if(bool){
                right = mid;
                
                System.out.println("bool="+bool + "(" + mid + ") => right="+right);
                
            }else{
                left = mid+1;
                System.out.println("bool="+bool  + "(" + mid + " => left="+left);
            }
            
            
            
        }
        
        return left;
        
    }
    
    
    private boolean isOk(int[] arr, int mid){
        
        
        for(int i=0; i<arr.length-mid; i++){ // i=0 1 2 3
            
            // [i~ i+mid-1] : ignore
            
            //[10,13,17,21,15,15,9,17,22,22,13] 11
            
            boolean flag = true;
            for(int j=0; j<arr.length-1-mid ; j++){ //j<3 0 1 2 
                
                int curr = (j>=i) ? j+mid : j;
                int next = (j+1>i) ? j+1+mid : j+1;
                
                if(arr[curr]>arr[next]){
                    flag=false;
                    break;
                }
            }
            
            if(flag){
                return true;
                
            }
                
        }
        
        return false;
    }
}