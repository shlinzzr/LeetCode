// https://leetcode.com/problems/sliding-window-maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        // TreeSet (nlogn)
        int len = nums.length;
        int[] res = new int[len-k+1];
        
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i<len; i++){ // O(N)
            
            set.add(nums[i]); // O(logN)
            
            System.out.println("i=" + i + " nums[i]=" + nums[i] + " " + set);
            
            
            if(set.size()>k){
                set.remove(nums[i-k]);
            }
            
            if(i+1-k>=0){
                res[i-k+1]=set.last();
            }
            
            
        }
        
        return res;
        
        
        
        
        
        
//         int len = nums.length;
        
//         ArrayDeque<Integer> dq = new ArrayDeque(); //idx   // poll head, offer last
        
//         // =====> tail   ======>.   head
        
//         int[] res = new int[len-k+1];
        
//         for(int i=0; i<len; i++){
            
            
            
            
//             int cur = nums[i];
            
            
            
//             while(!dq.isEmpty() && nums[dq.peekLast()]<cur){
//                 dq.pollLast();
//             }
            
            
//             if(dq.isEmpty())
//                 dq.offer(i);
            
            
            
            
//             if(i+1-k>=0){
//                 res[i+1-k] = dq.peek();
//             }
            
            
            
            
            
//         }
        
        
        
        
    }
}