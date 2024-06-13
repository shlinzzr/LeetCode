// https://leetcode.com/problems/sliding-window-maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int len = nums.length;
        int[] res = new int[len-k+1];
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        for(int i=0; i<len; i++){
            
            int cur = nums[i];
            
            while(!dq.isEmpty() && cur> nums[dq.peekLast()]){
                dq.pollLast();
            }
            
            dq.offer(i);
            
            if(i-k+1>=0){
                res[i-k+1] = nums[dq.peek()];
            }
            
            
            //[ 3 2 1 ]
            //  i   dq.peek()
            
            if(i-k+1>=dq.peek()){
                dq.poll();
            }
        }
        
        return res;
        
/* test case
      
[1,3,-1,-3,5,3,6,7]
3
[1]
1
[1,-1]
1
[1,3,1,2,0,5]
3
[-7,-8,7,5,7,1,6,0]
4

*/
        
        
        
        
        
        
        
        
        
        
//         int len = nums.length;
//         ArrayDeque<Integer> dq = new ArrayDeque<>(); // poll head, offer last => phol;
        
//         //Queue  offer => tail [x, x, x, x, x] poll => head. // offer tail poll head; 給尾拉頭
//         //                last                first
//         //             new idx                old idx
        
//         int[] res = new int[len-k+1];
        
//         int idx = 0;
        
//         for(int i=0; i<len; i++){
            
//             int curr = nums[i];
//             //  ex: arr: [3 2 1 4]
//             //  當4進來 deque:=> tail [1 2 3] head
//             //        因為4都比之前的大: x x x 拋掉 
//             while(!dq.isEmpty() && curr >= nums[dq.peekLast()]){ //把之前插入太小的都拋掉
//                 dq.removeLast();
//             }

//             dq.offer(i);
            
//             if(i-k+1>=0){  // 有k個數了
//                 res[idx++] = nums[dq.peek()];
//             }
            
//             // idx:  0 1 2   3
//             // arr :[4 3 2 ] 1
//             //               i
//             // deque => 1 [2 3 4] **越前面index越老
//             //             ^   ^
//             //            i=2  dq.peek()==0
            
//             // 2-0.     >= 3-1            
//             if(i-dq.peek()+1>= k // curr -> head 已經滿最遠k個限制 準備要拋掉變k-1 for next round
//                 dq.poll();
//             }
//         }
//         return res;
        
        
        
        
        //  Java 會緩存-128和之間的整數127以獲得更好的性能
        // PriorityQueue: TLE
        //  O(NlgK)=> O(Nk), 因為 java 的 PriorityQueue.remove 使用了indexOf而不是binary search 
               
//         PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//         int len = nums.length;
//         int[] res = new int[len-k+1];
        
//         for(int i=0; i<nums.length; i++){ // N
//             pq.offer(nums[i]); // lgN
            
//             if(i-k+1>=0){
//                 res[i-k+1] = pq.peek(); // O(1)
//                 pq.remove(nums[i-k+1]); // O(lgN)
//             }
//         }
//         return res;
        
        
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