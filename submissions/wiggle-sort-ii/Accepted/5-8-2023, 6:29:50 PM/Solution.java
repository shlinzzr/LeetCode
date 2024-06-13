// https://leetcode.com/problems/wiggle-sort-ii

class Solution {
    public void wiggleSort(int[] nums) {
        
        int len = nums.length;
        
        Arrays.sort(nums);
        
        int[] temp = new int[len];
        for(int i=0; i<len; i++)
            temp[i] = nums[i];
        
        
        int mid = (len-1)/2;
        int end = len-1;
        
        // 1 2 3 <- med ,     4 5 <- end
        // 3 5 2 4 1
        
        for(int i=0; i<len; i++){
           nums[i] = (i % 2 == 0) ? temp[mid--] : temp[end--];
        }
        
    }
}
