// https://leetcode.com/problems/remove-duplicates-from-sorted-array

class Solution {
    public int removeDuplicates(int[] nums) {
        
        
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        
        for(int i=0; i<nums.length; i++){
            if(list.contains(nums[i]))
                continue;
            else {
                nums[idx++] = nums[i];
                list.add(nums[i]);
            }
        }
   
        int[] res = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }
        
        return idx;
    }
}