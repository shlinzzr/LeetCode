// https://leetcode.com/problems/sliding-window-maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int len = nums.length;
        int[] res = new int[len-k+1];
        int ri=0;
        Deque<Integer> q = new ArrayDeque<>();
        
//         q.offer(1);
//         q.offer(2);
//         q.offer(3);
        
//         System.out.println(q.peek());
//         System.out.println(q.peek());
//         q.peek();
//         for(int i : q){
//             System.out.print(i + ",");
//         }
        
        
		for (int i = 0; i < nums.length; i++) {
			
            while(!q.isEmpty() && q.size()> k){
                q.poll();
            }
            
            while(!q.isEmpty() && q.peek()<nums[i]){
                q.poll();
            }
            
            q.offer(nums[i]);
            if(i>=k-1)
                res[i-k+1] = q.peek();
            
            
            
			// // remove numbers out of range k
			// while (!q.isEmpty() && q.peek() < i - k + 1) {
			// 	q.poll();
			// }
			// // remove smaller numbers in k range as they are useless
			// while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
			// 	q.pollLast();
			// }
			// // q contains index... r contains content
			// q.offer(i);
			// if (i >= k - 1) {
			// 	res[ri++] = nums[q.peek()];
			// }
		}
		return res;
        
        
    }
}