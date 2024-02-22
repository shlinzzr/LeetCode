// https://leetcode.com/problems/minimum-operations-to-make-all-array-elements-equal

class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        
        int N = nums.length;
        long[] prefixSum = new long[N];
        
        for(int i = 0; i < N; i += 1) {
            if(i == 0) prefixSum[i] = nums[i];
            else {
                prefixSum[i] = prefixSum[i - 1] + nums[i];
            }
        }
                
        List<Long> answer = new ArrayList<>();
        
        for(int i = 0; i < queries.length; i += 1) {
            int q = queries[i];
            int idx = binarySearch(nums, q);
            if(idx == N) {
                answer.add(((N * 1L * q) - prefixSum[N - 1]));
            } else {
                long contri1 = (prefixSum[N - 1] - prefixSum[idx] + nums[idx]) - (N - idx) * 1L * q; // for larger > queries[i]
                long contri2 = 0;
                if(idx != 0) 
                    contri2 = (idx * 1L * q) - (prefixSum[idx - 1] - prefixSum[0] + nums[0]); // for smaller <= queries[i]
                answer.add((contri1 + contri2));
            }
        }
        
        return answer;
    }
    
    // returns the first index (idx) such that nums[idx] > target
    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] <= target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }
}