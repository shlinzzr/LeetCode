// https://leetcode.com/problems/maximal-score-after-applying-k-operations

class Solution {
    public long maxKelements(int[] nums, int k) {
        Arrays.sort(nums);
        
        int len = nums.length;
        
        int score=0;
        int idx=len-1;
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b)-> Integer.compare(b,a)
        );
        for(int n: nums){
            pq.offer(n);
        }
        
        
        while(k>0){
            
            int val = pq.poll();
            score+=val;
            
            val = (int) Math.ceil(nums[idx]/3);
            
            pq.offer(val);
            k--;
        }
        
        return score;
        
    }
}