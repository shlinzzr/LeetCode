// https://leetcode.com/problems/sliding-window-maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        
        ArrayDeque<Integer> dq = new ArrayDeque();
        
        int[] res = new int[len-k+1];
        
        int idx=0;
        for(int i=0; i<len; i++){
            
            while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()]) // curr比queue last大, 就把queue last拋掉
                dq.pollLast();
            
            dq.addLast(i);
            
            if(i+1 >=k) //可以開始記錄了
                res[idx++] = nums[dq.peekFirst()];
            
            if(i-dq.peekFirst()+1>=k) //dq內的max idx已超過k個了 把dq頭拋掉
                dq.removeFirst();
            
        }
        
        return res;
        
    }
}