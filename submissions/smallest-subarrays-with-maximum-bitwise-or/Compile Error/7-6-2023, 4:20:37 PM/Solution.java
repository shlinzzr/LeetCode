// https://leetcode.com/problems/smallest-subarrays-with-maximum-bitwise-or

class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int len = nums.length;
        int[] res = new int[len]; 
        int[] arr = new int[32];
        
        
        int st= 0;
        for(int ed= 0; ed<len; ed++){
            
            int n = nums[ed];
            int i=0;
            while(n>0){
                arr[i++] += n&1;
                n>>1;
            }
            
            int val = arrToint(arr);
            
            
            
            
            
        }
        
        
        
    }
    
    private int arrToint(int[] arr){
        
        int sum =0;
        int f=0;
        
        for(int i=0; i<32;i++){
            if(arr[i]>0){
                sum+= 2^i;
            }
        }
        
        return sum;
        
        
        
    }
    
}