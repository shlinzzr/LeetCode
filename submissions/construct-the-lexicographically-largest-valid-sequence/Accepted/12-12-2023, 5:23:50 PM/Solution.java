// https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence

class Solution {

    public int[] constructDistancedSequence(int n) {
        int[] res = new int[ 2*(n-1)+1 ];
        boolean[] seen = new boolean[n + 1];
        helper(res, seen, n, 0);
        return res;
    }

    private boolean helper(int[] res, boolean[] seen, int n, int idx) {
        if (idx == res.length) {
            return true;
        }
        if (res[idx] != 0) {
            return helper(res, seen, n, idx+1); // value already assigned in this position. So go ahead with the next index.

        }else {
            // we start from n to 1 since we need to find out the lexicographically largest sequence.
            for (int i = n; i >= 1; i--) {
                if (seen[i]) 
                    continue;
                    
                seen[i] = true;
                res[idx] = i;
                if (i == 1) {
                    if (helper(res, seen, n, idx+1)) return true;
                } else if (idx + i < res.length && res[idx + i] == 0) {
                    res[i + idx] = i; // assigning the second occurence of i in the desired position i.e, (current index + i )
                    if (helper(res, seen, n, idx+1)) return true; // largest possible sequence satisfying the given conditions found.
                    res[idx + i] = 0;
                }
                res[idx] = 0;
                seen[i] = false;
            }

        }
        return false;
    }
}
	
