// https://leetcode.com/problems/circular-array-loop

class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int len = nums.length;

        int slow = 0;
        int fast = 0;
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        while(set.size()<len){

            int idx = (slow+ nums[slow])%len;
            if(idx<0) idx+=len;
            if(idx>=len) idx-=len;
            slow = idx;
            set.add(idx);


            idx = (fast+nums[fast])%len;
            if(idx<0) idx+=len;
            if(idx>=len) idx-=len;

            if(fast==idx) return false;
            fast = idx;
            idx = (fast+nums[fast])%len;
            if(idx<0) idx+=len;
            if(idx>=len) idx-=len;
            if(fast==idx) return false;
            fast = idx;

            if(slow==fast)
                return true;


        }

        return false;
        

    }
}