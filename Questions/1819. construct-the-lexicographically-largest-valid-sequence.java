// https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence

class Solution {

    public int[] constructDistancedSequence(int n) {
        int[] res = new int[ 2*(n-1)+1 ];
        boolean[] seen = new boolean[n + 1];
        helper(res, seen, n, 0);
        return res;
    }

    // x x x x res[idx] x x x x x x res[idx+i]
    // add from n to 1 inorder to get the lexicographically largest sequence.
    
    private boolean helper(int[] res, boolean[] seen, int n, int idx) {
        if (idx == res.length) {
            return true;
        }
        if (res[idx] != 0) {
            return helper(res, seen, n, idx+1); // if value already assigned in this position. So go ahead with the next index.

        }else {
            // we start from n to 1 since we need to find out the lexicographically largest sequence.
            for (int i = n; i >= 1; i--) {
                if (seen[i]) 
                    continue;
                    
                seen[i] = true;
                res[idx] = i;
                if (i == 1) { // no need add by rule when add "1".
                    if (helper(res, seen, n, idx+1)) return true;
                    
                } else if (idx + i < res.length && res[idx + i] == 0) {
                    res[i + idx] = i; // assigning the second occurence of i in the desired position i.e, (current index + i )
                    if (helper(res, seen, n, idx+1)) return true; // largest possible sequence satisfying the given conditions found.
                    res[idx + i] = 0; //backtrack
                }
                res[idx] = 0; //backtrack
                seen[i] = false; //backtrack
            }

        }
        return false;
    }
}
	
