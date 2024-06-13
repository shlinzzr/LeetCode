// https://leetcode.com/problems/russian-doll-envelopes

class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        int len = envelopes.length;
        Arrays.sort(envelopes, (a,b) -> a[0]!=b[1] ? a[0]-b[1] : a[1]-b[1]);

        int[] dp = new int[len];

        for (int i=0; i<len; i++) {
            dp[i] = 1;
            for (int j=0; j<i; j++) {
                if (envelopes[j][0]<envelopes[i][0] && envelopes[j][1]<envelopes[i][1])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }
        
        int ret = 0;
        for (int i=0; i<len; i++)
            ret = Math.max(ret, dp[i]);
        return ret;
    }



    public ArrayList<Integer> lengthOfLIS(int[][] nums, int idx) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i][idx];
            if (num > nums[list.get(list.size() - 1)][idx]) {
                list.add(i);
            } else {
                // Find the first element in sub that is greater than or equal to num
                int j = 0;
                while (num > nums[list.get(j)][idx]) {
                    j += 1;
                }
                
                list.set(j, i);
            }
        }

        return list;
    }
}