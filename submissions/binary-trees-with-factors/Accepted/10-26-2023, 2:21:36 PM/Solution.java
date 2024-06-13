// https://leetcode.com/problems/binary-trees-with-factors

class Solution {
    public int numFactoredBinaryTrees(int[] A) {

        long res = 0L, mod = (long)1e9 + 7;
        Arrays.sort(A);
        HashMap<Integer, Long> dp = new HashMap<>();

        int len = A.length;
        for(int i=0; i<len; i++){
            dp.put(A[i], 1L);

            for(int j=0; j<i; j++){
                if (A[i] % A[j] == 0){
                    dp.put(A[i], (dp.get(A[i]) + dp.get(A[j]) * dp.getOrDefault(A[i] / A[j], 0L)) % mod);
                }
            }
            res = (res + dp.get(A[i])) % mod;
        }

        return (int)res;
           
    }
}