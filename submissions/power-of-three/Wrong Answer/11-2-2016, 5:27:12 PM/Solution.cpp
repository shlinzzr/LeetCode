// https://leetcode.com/problems/power-of-three

class Solution {
public:
    bool isPowerOfThree(int n) {
        
        
        
        if(n%3 != 0 && n!=0)
            return false;
        
        return true;
    }
};