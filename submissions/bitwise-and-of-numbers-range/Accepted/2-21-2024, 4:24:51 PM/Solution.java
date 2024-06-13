// https://leetcode.com/problems/bitwise-and-of-numbers-range

class Solution {
    public int rangeBitwiseAnd(int left, int right) {


        // 5 : 101
        // 6 : 110
        // 7 : 111

        //https://www.youtube.com/watch?v=CY1tnj53L_k

        //只要 left , right 不相等 中間數一定出現0

        //兩個int 長度不相等一定是0
        // if(String.valueOf(left).length()!=String.valueOf(right).length()){
        //     return 0;
        // }

        int cnt = 0;
        while(left!=right){
            left>>=1;
            right>>=1;
            cnt++;
        }

        return left<<cnt;
        
    }
}