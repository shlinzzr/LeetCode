// https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor

class Solution {
    public int countTriplets(int[] arr) {

        state = 0; 

        Map<Integer, Integer> map = new HashMap<>(); // state , cnt;
        map.put(0, 1);

        int len = arr.length;
        int ans=0;

        for(int i=0; i<len; i++){

            state ^= arr[i];

            if(map.containsKey(state)){
                ans += map.get(state);
            }
            map.put(state, map.getOrDefault(state, 0)+1);
        }

        return ans;

        
    }
}