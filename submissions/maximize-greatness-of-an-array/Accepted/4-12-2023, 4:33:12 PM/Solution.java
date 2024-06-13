// https://leetcode.com/problems/maximize-greatness-of-an-array

class Solution {
    public int maximizeGreatness(int[] A) {
         Arrays.sort(A);
        int res = 0;
        for (int a : A)
            if (a > A[res])
                res++;
        return res;
    }
}

//[1,3,5,2,1,3,1]
//[2,5,1,3,3,1,1]. 4


// 1 1 1 2 3 3 5
// 1 1 2 3 3 5 1 res = 3