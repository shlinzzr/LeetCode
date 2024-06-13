// https://leetcode.com/problems/add-digits

class Solution {
public:
    int addDigits(int num) {
        int a = num / 10;
        int b = num % 10 ;
        if(a+b<10 && a!=0 && b!=0)
        return a + b;
        else return a+b;
    }
};