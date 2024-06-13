// https://leetcode.com/problems/sliding-window-maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int len = nums.length;
        int[] res = new int[len-k+1];
        
        for(int i=0; i<nums.length; i++){
            pq.offer(nums[i]);
            
            if(i-k+1>=0){
                res[i-k+1] = pq.peek();
                pq.remove(nums[i-k+1]);
            }
        }
        
        return res;
        
        
        
        
        
        
        
        
//         // TreeMap O(NlgN)
//         TreeMap<Integer, Integer> map = new TreeMap<>(); // nums[i], cnt 
//         int len = nums.length;
//         int[] res = new int[len-k+1];
        
//         int windowSize=0;
//         for(int i=0; i<len ;i++){
//             int cur = nums[i];
//             map.put(cur, map.getOrDefault(cur, 0)+1);
//             windowSize++;
            
//             if(windowSize>k){
//                 map.put(nums[i-k], map.get(nums[i-k])-1);
//                 windowSize--;
             
//                 if(map.get(nums[i-k])==0) // 要用map來存 才能保留key
//                     map.remove(nums[i-k]);
//             }
            
//             if(i+1-k>=0){
//                 res[i+1-k] = map.lastKey();
//             }
//         }
        
//         return res;
        
        
        
    }
}