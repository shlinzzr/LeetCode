// https://leetcode.com/problems/minimum-cost-to-connect-sticks

class Solution {
    public int connectSticks(int[] sticks) {
        Arrays.sort(sticks);
        int len = sticks.length;
        int[] presum = new int[sticks.length];
        for(int i=0; i<sticks.length; i++){
            presum[i] = i==0 ? sticks[i] : presum[i-1] + sticks[i];
        }

        int res = 0;
        for(int i=1; i<len; i++){
            res += presum[i];
        }

        return res;
    }
}

// 2 3 4 

 