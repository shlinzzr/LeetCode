// https://leetcode.com/problems/calculate-money-in-leetcode-bank

class Solution {
    public int totalMoney(int n) {
        // 1234567
        // 2345678
        // ...
        int res = 0;
        int plus =0 ;
        int cur = 0;
        while(n>0){

            if(n>7){
                res+=28;
                res+=7*plus;
                plus++;
                n-=7;
            }else{
                res+= (1+n)*n/2;
                res+= n*plus;
                break;
            }
        }

        return res;
    }
}