// https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum

class Solution {
    public int numOfSubarrays(int[] arr) {
        
        int len = arr.length;
        
        long[] presum = new long[len];
        
        long  res = 0;
        
        for(int i=0; i<len; i++){
            
            presum[i] = i==0? arr[0] : arr[i]+presum[i-1];
            
            if(presum[i]%2==1)
                res++;
            
            for(int j=0; j<i; j++){
                
                if((presum[i]-presum[j])%2==1){
                    res++;
                }
            }
        }
        
        int M = (int) 1e9+7;
        
        return (int) (res%M);
        
    }
}