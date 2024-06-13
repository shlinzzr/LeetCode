// https://leetcode.com/problems/sliding-subarray-beauty

class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int len = nums.length;

        int[] res = new int[len-k+1];

        PriorityQueue<Integer> pq1 = new PriorityQueue<>(
            (a,b) -> b-a
        );
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        int st =0;
        for(int ed=0; ed<len; ed++){

            if(pq1.size()<x)
                pq1.offer(nums[ed]);
            else{

                if(pq1.peek()>nums[ed]){
                    pq2.offer(pq1.poll());
                    pq1.offer(nums[ed]);
                }else{
                    pq2.offer(nums[ed]);
                }
            }

            if(ed<k-1) continue;

            if(pq1.size()==x && pq1.peek()<0){
                res[st] = pq1.peek();
            }

            
            System.out.println(pq1 + " "  + pq2);

            if(nums[st]>pq1.peek()){
                pq2.remove(nums[st]);
            }else{
                pq1.remove(nums[st]);

                if(!pq2.isEmpty())
                    pq1.offer(pq2.poll());
            }
            st++;


        }

        return res;

    }
}