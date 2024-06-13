// https://leetcode.com/problems/find-the-duplicate-number

class Solution {
    public int findDuplicate(int[] nums) {
        
        // floyd's
        
        int fast = nums[0];
        int slow = nums[0];

        while(true){

            fast = nums[nums[fast]];
            slow = nums[slow];

            if(fast==slow)
                break;

        }
        
        slow = nums[0];
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;

    }
}