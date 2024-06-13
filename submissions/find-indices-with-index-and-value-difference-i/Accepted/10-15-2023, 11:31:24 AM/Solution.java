// https://leetcode.com/problems/find-indices-with-index-and-value-difference-i

class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int[] res = new int[]{-1, -1};
        
        int len = nums.length;
        for(int i=0; i<len; i++){
            for(int j=i+indexDifference; j<len; j++){
                
                if(Math.abs(nums[i]-nums[j])>=valueDifference){
                    return new int[]{i, j};
                }
                
            }
        }
        
        return res;
    }
}