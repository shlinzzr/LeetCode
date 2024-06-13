// https://leetcode.com/problems/minimum-operations-to-form-subsequence-with-target-sum

class Solution {
    public int minOperations(List<Integer> nums, int target) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        long sum=0;
        long count=0;
        for(int x:nums)
        {
            pq.offer(x);
            sum+=x;
        }
        // if sum is less than target impossible to  achieve this target
        if(sum<target)
            return -1;
        // starting from highest element in priority queue
        while(!pq.isEmpty())
        {
            int val=pq.poll();
            sum-=(long)val;
            // if val less than target update target
            if(val<=target)
            {
                target-=val;
            }
            // if val is greater than target but it sum is less than target 
            // we will break the val into 2 half and increase count and update our sum
            // if sum is greater than target it is not possoble to achieve this target this means 
            // we will delete or not using this number 
            else if(val>target && sum<target)
            {
                count++;
                pq.offer(val/2);
                pq.offer(val/2);
                sum+=(long)val;
            }
        }
        return (int)count;
    }
}