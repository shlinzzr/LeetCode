// https://leetcode.com/problems/non-decreasing-array

class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean seen = false;
        
       
        for(int i=0; i<nums.length-1; i++){
            
            if(nums[i]<=nums[i+1])
                continue;
            
            if(seen)
                 return false;
            
            
            // chg front //  1   4   2
                         // i-1  i  i+1
            //   現在狀態         ^^^^^^^
            // 如果可以讓nums[i]變小, 儘量選num[i]變小
            if(i==0 || nums[i-1]<=nums[i+1]) // i=0 is because there is no n-1 element to check
                nums[i]= nums[i+1]; // shrink left
            else
                nums[i+1] = nums[i]; //不然只能讓nums[i+1]變大 不過更可能讓後面失敗
            seen=true;
        }
        return true;
    }
}