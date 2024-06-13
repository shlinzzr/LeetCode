// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int len = numbers.length;
        
        int st=0, ed=len-1;
        
        while(st<ed){
            
            int sum = numbers[st]+numbers[ed];
            if(sum==target){
                return new int[]{st+1,ed+1};
            }else if(sum<target){
                st ++;
                
            }else{
                ed--;
            }
            // nlgn vs n
            
            
        }
        
        return new int[]{-1,-1};
        
    }
}