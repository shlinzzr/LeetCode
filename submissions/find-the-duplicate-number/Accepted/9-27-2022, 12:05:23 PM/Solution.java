// https://leetcode.com/problems/find-the-duplicate-number

class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] bool = new boolean[nums.length];
        
        int i=0;
        int idx =0;
        while(i<nums.length){
            // System.out.println(idx);
            if(bool[nums[idx]]==false){
                bool[nums[idx]]=true;
                idx = nums[idx];
                
            }else{
                return nums[idx];
            }
            i++;
        }
        
        return -1;
    }
}