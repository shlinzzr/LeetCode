// https://leetcode.com/problems/shuffle-the-array

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] arr = new int[2*n];
        int idx=0;
        for(int i=0; i<n; i++){
            arr[idx++] = nums[i];
            arr[idx++] = nums[n+i];
        }
        return arr;
        
    }
}