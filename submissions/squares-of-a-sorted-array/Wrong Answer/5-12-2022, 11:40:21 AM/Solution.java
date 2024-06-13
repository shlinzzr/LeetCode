// https://leetcode.com/problems/squares-of-a-sorted-array

class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int st=0, ed=nums.length-1;
        
        int len=nums.length-1;
        int [] arr= new int [nums.length];
    
        
        while(len>0){
            
            if(Math.abs(nums[st]) < Math.abs(nums[ed]) ){
                arr[len] = nums[ed]*nums[ed];
                ed--;
                
            }else{
                arr[len] = nums[st]*nums[st];
                st++;
                
            }
            len--;
            
        }
        return arr;
    }
}