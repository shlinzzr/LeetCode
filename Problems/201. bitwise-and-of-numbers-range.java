// https://leetcode.com/problems/bitwise-and-of-numbers-range

class Solution {
    public int rangeBitwiseAnd(int left, int right) {


        // 5  : 0101
        // 6  : 0110
        // 7  : 0111

        // 8  : 1000
        // 9  : 1001
        // 10 : 1010

        //https://www.youtube.com/watch?v=CY1tnj53L_k

        //只要 left , right 不相等 該末digit一定出現0

        //兩個int 長度不相等一定是0
        if(Integer.toBinaryString(left).length()!=Integer.toBinaryString(right).length())
            return 0;


        int cnt = 0;
        while(left!=right){
            left>>=1;
            right>>=1;
            cnt++;

            System.out.println(left + " "  + right + " " + cnt);
        }

 System.out.println(left + " "  + right + " " + cnt);

        return left<<cnt;
        
    }
}