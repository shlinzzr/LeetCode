// https://leetcode.com/problems/single-number-ii

class Solution {
    public int singleNumber(int[] nums) {
        
        //https://www.youtube.com/watch?v=vtsPnud1ahU
        
        // solution 1
        // int[] arr = new int[32];
        // for(int x : nums){
        //     for(int i=0; i<32;i++){
        //         arr[i]+= (x>>i)&1;
        //     }
        // }
        // int res = 0;
        // for(int i=0; i<32; i++){
        //     res+= (arr[i]%3)<<i;
        // }
        // return res;
        
        
        //sol 2: 
        int res =0 ;
        for(int i=0; i<32; i++){
            
            int sum = 0;
            for(int x: nums){
                sum+=(x>>i)&1;
            }
            
            res += (sum%3)<<i;
        }
        
        return res;
        
        
        
        
    }
}