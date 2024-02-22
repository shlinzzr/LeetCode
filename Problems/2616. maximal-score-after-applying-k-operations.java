// https://leetcode.com/problems/maximal-score-after-applying-k-operations

class Solution {
    public long maxKelements(int[] nums, int k) {
        Arrays.sort(nums);
        
        int len = nums.length;
        
        long score=0;
        int idx=len-1;
        
        
        PriorityQueue<Long> pq = new PriorityQueue<>(
            (a,b)-> Long.compare(b,a)
        );
        for(int n: nums){
            pq.offer((long)n);
        }
        
        
        while(k>0){
            
            long val = pq.poll();
            score+=val;
            val = val%3==0? val/3 :  val/3+1;
            
            pq.offer(val);
            k--;
        
        }
        
        
        
        // 10 + 4 + 3 
        
        return score;
        
    }
}