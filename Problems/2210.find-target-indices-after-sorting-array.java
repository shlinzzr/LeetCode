// https://leetcode.com/problems/find-target-indices-after-sorting-array

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        
        
        Arrays.sort(nums);
        int n = nums[0], i=-1;
        
        while(i<nums.length-1 && n<=target){
            
            n=nums[++i];
            
            if(n==target)
                list.add(i);
        }
        
        return list;
            
    }
}