// https://leetcode.com/problems/make-the-prefix-sum-non-negative

class Solution {
    public int makePrefSumNonNegative(int[] nums) {


        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // long prefixSum = 0;
        // int res = 0;
        // for (int num : nums) {
        //     prefixSum += num;
        //     pq.add(num);
        //     if (prefixSum < 0) {
        //         res++;
        //         prefixSum -= pq.poll();
        //     }
        // }
        // return res;


        int len = nums.length;

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<len; i++){
            list.add(nums[i]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();


        int[] presum = new int[len];

        int res = 0;

        int idx= 0 ;
        for(int i=0; i<list.size(); i++){
            presum[idx] = idx==0? list.get(i) : presum[idx-1]+ list.get(i);
            pq.offer(list.get(i));
            if(presum[idx]<0){
                res++;
                int p = pq.poll();
                if(idx>=0)
                    presum[idx] -= p;
            }
            idx++;
        }

        return res;
    }
}