// https://leetcode.com/problems/shortest-unsorted-continuous-subarray

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int min = nums[len-1];
        int max= nums[0];

        // nums 要改成 non-desc 
        // 因此邊界是不用改的, from 1~len-2

        int st =len-1, ed=0;
        for(int i=1; i<len; i++){
            max = Math.max(max, nums[i]); // 從左邊數來第i個idx (start from 0)
            min = Math.min(min, nums[len-i-1]); // 從右邊數來第i個idx (start from 0)

            if(nums[i]<max) ed = i;  // 如果現在cur比左邊看過來的max 還小 表示打破了 non-desc 更新需要修改得subarray.end
            if(nums[len-i-1]>min) st = len-i-1; // 如
            
        }

        return st>=ed ? 0 : ed-st+1;

        
    }
}