// https://leetcode.com/problems/maximum-number-of-pairs-in-array

class Solution {
    public int[] numberOfPairs(int[] nums) {
        
        int[] arr = new int[101];
        for(int n: nums){
            arr[n]++;
        }
        
        int pair=0, left =0;
        
        
        for(int a : arr){
            pair+= a/2;
            left+= a%2;
        }
        
        return new int[]{pair, left};
        
        
    }
}