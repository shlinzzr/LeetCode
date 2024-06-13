// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        
        int len = numbers.length;
        
        for(int i=0; i<len;i++){
            
            int st=i, ed=len-1;
            while(st<ed){
                
                if(numbers[st]+numbers[ed]==target)
                    return new int[]{st+1, ed+1};
                
                else if(numbers[st]+numbers[ed]>target){
                    ed = st+(ed-st)/2;
                }else{
                    continue;
                }
            }
        }
        
        return new int[2];
    }
}