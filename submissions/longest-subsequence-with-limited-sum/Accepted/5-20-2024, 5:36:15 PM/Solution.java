// https://leetcode.com/problems/longest-subsequence-with-limited-sum

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {

        int n = nums.length;
        int m = queries.length;
        int[] ans = new int[m];

        Arrays.sort(nums);

        for(int i=0; i<m; i++){
            int q = queries[i];
            int j=0;
            for(int sum=0; j<n; j++){
                sum+= nums[j];
                if(sum>q) break;
            }
            ans[i] = j;
           
        }

        return ans;

        
    }
}