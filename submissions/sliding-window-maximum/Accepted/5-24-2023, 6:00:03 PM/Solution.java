// https://leetcode.com/problems/sliding-window-maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        
        ArrayDeque<Integer> dq = new ArrayDeque<>(); // poll head, offer last => phol;
        
        int[] res = new int[len-k+1];
        
        int idx = 0;
        
        for(int i=0; i<len; i++){
            
            int curr = nums[i];
            
            while(!dq.isEmpty() && curr >= nums[dq.peekLast()]){ //把之前插入太小的都拋掉
                dq.removeLast();
            }
            
            dq.offer(i);
            
            if(i-k+1>=0){  // 有k個數了
                res[idx++] = nums[dq.peek()];
            }
            
            if(i-dq.peek()+1>= k){ // head超過距離k的限制 要poll掉
                dq.poll();
            }
        }
        return res;
        
    }
}