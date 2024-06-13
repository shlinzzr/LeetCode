// https://leetcode.com/problems/sum-of-all-odd-length-subarrays

class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0;

        int odd =1;
        
        while(odd<=arr.length){
            
            for(int i=0; i<=arr.length-odd;i++){
            
                res += sumArray(Arrays.copyOfRange(arr, i, i+odd));
               
                
            }
            
             odd +=2;
            // break;
            
        }
        
        return res;
        
        
        
    }
    
    
    private int sumArray(int[] arr){
        int res = 0;
        for(int i:arr)
            res+=i;
        return res;
    }
}