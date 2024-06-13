// https://leetcode.com/problems/double-modular-exponentiation

import java.math.BigInteger;

class Solution {
    public List<Integer> getGoodIndices(int[][] arr, int target) {
        List<Integer> al = new ArrayList<>();
        BigInteger ten = new BigInteger("10");
        for(int i=0; i<arr.length; i++){
            // long calc = Math.pow(Math.pow(arr[i][0], arr[i][1]) % 10, arr[i][2])%arr[i][3];
            BigInteger a = new BigInteger(arr[i][0]+"");
            int b = arr[i][1];
            int c = arr[i][2];
            int m = arr[i][3];
            BigInteger x = a.pow(b);
            BigInteger y = x.mod(ten);
            BigInteger z = y.pow(c);
            BigInteger d = new BigInteger(m+"");
            BigInteger res = z.mod(d);            
            
            if(res.intValue() == target)
                al.add(i);
        }
        
        return al;
    }
}