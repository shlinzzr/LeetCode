// https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k

class Solution {
    public int shortestSubarray(int[] nums, int k) {    

        int len = nums.length;
        int[] presum = new int[len];
        for(int i=0; i<len; i++){
            presum[i] = i==0 ? nums[0] : presum[i-1] + nums[i];
        }


        // 找 shortest
        // nums  2 -1 2
        // presum 2 1 3
        //        i. cur  : --> peek(i) presum[cur]-presum[i] >= k  有的話就pop() 求min
        // poll() ---->找近的i 
        // 除此之外 把前面比自己大的cur都幹掉 
        // 因為自己相對於前面 presum更小的話 更容易滿足k 也更近
        Deque<Integer> dq = new ArrayDeque<Integer>();
        int min = len+1;
        for(int i=0; i<len; i++){
            int cur = presum[i];

            if(cur>=k){
                min = Math.min(min, i+1);
            }

            while(!dq.isEmpty() && cur-presum[dq.peek()]>=k){
                min = Math.min(min, i-dq.poll()+1);
            }
            dq.offer(i);


        }

        return min==len+1 ? -1 : min;
        
    }
}