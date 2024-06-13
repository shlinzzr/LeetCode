// https://leetcode.com/problems/longest-subsequence-with-limited-sum

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {

        int n = nums.length;
        int m = queries.length;
        int[] ans = new int[m];

        // O(nlgn + mn) .... not good
        // the best sol is using presum + binarysearch to enhance perf
        // ==> O(nlgn + n + mlgn) => O((m+n)lgn) ... since nlgn>n


        Arrays.sort(nums); // O(nlgn)

        for(int i=0; i<m; i++){ // O(m)
            int q = queries[i];
            int j=0;
            for(int sum=0; j<n; j++){ // O(n)
                sum+= nums[j];
                if(sum>q) break;
            }
            ans[i] = j;
           
        }

        return ans;

        
    }
}