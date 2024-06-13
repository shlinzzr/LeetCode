// https://leetcode.com/problems/sliding-window-maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        
        ArrayDeque<Integer> dq = new ArrayDeque(); // poll head, offer last
        
        int[] res = new int[len-k+1];
        
        int idx=0;
        for(int i=0; i<len; i++){
            
            while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()]) // curr比queue last(tail) 大, 就把queue last(tail)拋掉
                dq.pollLast();
            
            dq.addLast(i); // === dq.offer(i);
            
            if(i+1 >=k) //when idx>=k   => 可以開始記錄了
                res[idx++] = nums[dq.peekFirst()];
            
            if(i-dq.peekFirst()+1>=k) //check dq內的element, 如果idx已超過k個了 把dq頭拋掉
                dq.removeFirst(); // ==> dq.poll();
            
        }
        
        return res;
        
    }
}