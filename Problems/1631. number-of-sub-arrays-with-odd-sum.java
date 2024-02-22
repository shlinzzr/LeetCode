// https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum

class Solution {
    public int numOfSubarrays(int[] arr) {
        
        int len = arr.length;
        
        int M = (int) 1e9+7;
        
        int odd=0, even=1, presum=0, res=0;
        
        for(int i=0; i<len; i++){
            presum += arr[i];
            
            if(presum%2==0){
                
                res = (res + odd)%M;
                even++;
                
            }else{
                
                res = (res + even)%M;
                odd++;
                
            }
            
            
        }
        
        
        
        
        return (int) (res%M);
        
    }
}