// https://leetcode.com/problems/xor-operation-in-an-array

class Solution {
    public int xorOperation(int n, int start) {
        
        int res = start;
        for(int i=0; i<n-1; i++){
            res =  res ^ (start+2);
            start = start+2;
        }
        return res;
        
    }
}