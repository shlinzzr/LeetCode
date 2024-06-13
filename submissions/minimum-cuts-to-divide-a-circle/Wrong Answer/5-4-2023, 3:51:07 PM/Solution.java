// https://leetcode.com/problems/minimum-cuts-to-divide-a-circle

class Solution {
    public int numberOfCuts(int n) {
        
        if(n%2==0)
            return n/2;
        else 
            return n;
        
    }
}