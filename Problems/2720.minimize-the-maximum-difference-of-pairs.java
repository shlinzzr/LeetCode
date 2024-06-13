// https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs

class Solution {
    public int minimizeMax(int[] A, int p) {
        Arrays.sort(A);
        int n = A.length, left = 0, right = A[n - 1] - A[0];
        while (left < right) {
            int mid = (left + right) / 2, k = 0;
            
            for (int i = 1; i < n && k < p; ++i) {
                if (A[i] - A[i - 1] <= mid) {
                    k++; //如果之間的差<mid 就select this tuple , otherwise 考慮下一對:  A[i+1], A[i] 這個pair
                    i++; // i++ 考慮下一對:  A[i+2], A[i+1] 這個pair
                }
            }
            if (k >= p)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
        
        
    }
}