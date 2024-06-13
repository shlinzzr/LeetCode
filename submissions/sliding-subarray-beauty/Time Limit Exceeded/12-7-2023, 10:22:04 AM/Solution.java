// https://leetcode.com/problems/sliding-subarray-beauty

class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int len = nums.length;

        int[] res = new int[len-k+1];

        PriorityQueue<Integer> pq = new PriorityQueue<>(
          (a,b) -> a-b
        );

        // TreeMap<Integer, Integer> map = new TreeMap<>();

        int st =0;
        for(int ed=0; ed<len; ed++){
            // map.put(nums[ed], map.getOrDefault(nums[ed], 0)+1);
            pq.offer(nums[ed]);
            if(ed<k-1) continue;

            List<Integer> list = new ArrayList<>(pq);
            Collections.sort(list);
            // System.out.println(list);

            if(list.size()>=x && list.get(x-1)<0)
              res[st]= list.get(x-1);

            pq.remove(nums[st]);
            st++;


        }

        return res;

    }
}