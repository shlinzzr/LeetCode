// https://leetcode.com/problems/count-of-interesting-subarrays

class Solution {

    //      l     r
    // x x [a x b x] x x x 
    //      |   |
    //      v   v
    //    a, b % M ==k , cnt=2 , at the same time cnt%M=k
    

    // the first thing : 
    // nums turns into nums%M
    //      l     r
    // 0 0 [1 0 1 0] 0 1 1

    //
    // the second : agg @ cntMap // Map : m:0~m-1, cnt


    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        // [ x x x x x x ]
        //     l     r
        //     i          cnt : 有幾個nums[i]%modulo==k , 同時 cnt%modulo===k

        int len = nums.size();
        int[] arr = new int[nums.size()];
        for(int i=0; i<nums.size(); i++){
            arr[i] = (nums.get(i)%modulo==k ? 1 : 0);
        }

        Map<Long, Long> map = new HashMap<>(); // state , cnt
        map.put(0L, 1L);
        long state = 0;
        long ans = 0;
        for(int i=0; i<len;i++){

            int a = arr[i];
            state = (state+a)%modulo;
            
            long key = (state-k + modulo)%modulo;

            if(map.containsKey(key)){
                ans += map.get(key);
            }

            map.put(state, map.getOrDefault(state,0L)+1);


        }

        return ans;



     }
}