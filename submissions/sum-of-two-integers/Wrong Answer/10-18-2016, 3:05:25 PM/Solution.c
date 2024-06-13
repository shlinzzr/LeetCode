// https://leetcode.com/problems/sum-of-two-integers

int getSum(int a, int b) {
    return a^b|((a&b)<<1);
}