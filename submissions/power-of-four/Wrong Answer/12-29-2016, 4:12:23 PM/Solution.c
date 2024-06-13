// https://leetcode.com/problems/power-of-four

bool isPowerOfFour(int num) {
    return (num>0 && num&(num-1) == 0 &&  num&0x5555!=0);
}