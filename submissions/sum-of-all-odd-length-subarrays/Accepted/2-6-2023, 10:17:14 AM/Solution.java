// https://leetcode.com/problems/sum-of-all-odd-length-subarrays

class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum=0;
        int len = arr.length;
        
        for(int i=1; i<=len; i+=2){
            
            
            for(int j=0; j<len; j++){
                
                int st=j, ed=st+i;
                for(int k=st; k<ed&&ed<=len; k++){
                    sum+=arr[k];
                }
            }
        }
        
        return sum;
    }
}