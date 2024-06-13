// https://leetcode.com/problems/count-the-number-of-beautiful-subarrays

class Solution {
    public long beautifulSubarrays(int[] nums) {
        
        // 翻譯: 找出一個subarray 他的每個bit==1個數相加起來是偶數
        // 用state 紀錄 **********01  req : 出現偶數次1
        
        HashMap<Integer, Integer> map = new HashMap<>(); // state, 出現次數
        map.put(0, 1);
        
        int state = 0;
        long res = 0;
        for (int a : nums) {
            state ^= a;
            int v = map.getOrDefault(state, 0);
            res += v;
            map.put(state, v + 1);
        }
        return res;
    }
}