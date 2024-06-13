// https://leetcode.com/problems/earliest-second-to-mark-indices-i

class Solution {
    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        
        
        int n = nums.length; 
        int m = changeIndices.length;
        
        HashMap<Integer, Integer> lastOccur = new HashMap<>();
        
        for(int i=0; i<m; i++){
            lastOccur.put(changeIndices[i]-1, i);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq= new PriorityQueue<>(
            (a,b)->a.getValue()-b.getValue()
        );
        
        pq.addAll(lastOccur.entrySet());
        
        /*
        Input: nums = [2,2,0], changeIndices = [2,2,2,2,3,2,2,1]
Output: 8
Explanation: In this example, we have 8 seconds. The following operations can be performed to mark all indices:
Second 1: Choose index 1 and decrement nums[1] by one. nums becomes [1,2,0].
Second 2: Choose index 1 and decrement nums[1] by one. nums becomes [0,2,0].
Second 3: Choose index 2 and decrement nums[2] by one. nums becomes [0,1,0].
Second 4: Choose index 2 and decrement nums[2] by one. nums becomes [0,0,0].
Second 5: Mark the index changeIndices[5], which is marking index 3, since nums[3] is equal to 0.
Second 6: Mark the index changeIndices[6], which is marking index 2, since nums[2] is equal to 0.
Second 7: Do nothing.
Second 8: Mark the index changeIndices[8], which is marking index 1, since nums[1] is equal to 0.
Now all indices have been marked.
It can be shown that it is not possible to mark all indices earlier than the 8th second.
Hence, the answer is 8.

*/
        
        // lastOccur.put(changeIndices[i], i+1);
        
        // nums = [1,3], changeIndices = [1,1,1,2,1,1,1]
       // pq [2,4] , [1, 7] 
        
        boolean[] seen = new boolean[n];
        
        int last = 0;
        int sec =0;
        while(!pq.isEmpty()){
            
            int idx = pq.peek().getKey(); // 3-1===2
            
            if(sec > pq.peek().getValue()) return -1;
            /*
            
            Choose an index i in the range [1, n] and decrement nums[i] by 1.
            If nums[changeIndices[s]] is equal to 0, mark the index changeIndices[s].
            Do nothing.*/
            
            if(nums[idx]>0){
                nums[idx]--;
            }else if(nums[idx]==0){
                
                
                if(pq.size()>1)
                    last = pq.peek().getValue();
                seen[idx]=true;
                pq.poll();
            }
            
              sec++;
        }
        
        
        for(int i=0; i<n; i++){
            if(seen[i]==false) return -1;
        }
        
        return sec+1;
        
    }
}