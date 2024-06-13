// https://leetcode.com/problems/find-target-indices-after-sorting-array

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        
        
        Arrays.sort(nums);
        int n = nums[0], i=0;
        
        while(n<=target){
            if(n==target)
                list.add(i);
            
            n=nums[++i];
            
        }
        
        return list;
            
    }
}