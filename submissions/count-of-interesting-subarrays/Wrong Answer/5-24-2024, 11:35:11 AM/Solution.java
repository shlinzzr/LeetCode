// https://leetcode.com/problems/count-of-interesting-subarrays

class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        // [ x x x x x x ]
        //     l     r
        //     i          cnt : 有幾個nums[i]%modulo==k , 同時 cnt%modulo===k

        int len = nums.size();
        int[] arr = new int[nums.size()];
        for(int i=0; i<nums.size(); i++){
            arr[i] = (nums.get(i)%modulo==0 ? 1 : 0);
        }

        Map<Integer, Integer> map = new HashMap<>(); // state , cnt
        map.put(0, 1);
        int state = 0;
        int ans = 0;
        for(int i=0; i<len;i++){

            int a = arr[i];
            state = (state+a)%modulo;
            
            int key = (state-k + modulo)%modulo;

            if(map.containsKey(key)){
                ans += map.get(key);
            }

            map.put(state, map.getOrDefault(state,0)+1);


        }

        return ans;



     }
}