// https://leetcode.com/problems/can-make-palindrome-from-substring

class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> ans = new ArrayList<>(); 
        int len = s.length();

        int[] prexor = new int[len + 1]; // odds[i]: within range [0...i) of s, the jth bit of odd[i] indicates even/odd of the count of (char)(j + 'a'). 
        for (int i = 0; i < len; ++i)
            prexor[i + 1] = prexor[i] ^ (1 << (s.charAt(i) - 'a'));

        // prexor  

        // a^b^c^d^e

        // q= [b,c]
        // a b 

        for (int[] q : queries)
            ans.add(Integer.bitCount(prexor[q[0]] ^ prexor[q[1]+1]) <= q[2]*2); // odds[q[1] + 1] ^ odds[q[0]] indicates the count of (char)(i + 'a') in substring(q[0], q[1] + 1) is even/odd.
        return ans;
    }

}