// https://leetcode.com/problems/counting-bits

class Solution {
    
    //https://leetcode.com/problems/counting-bits/discuss/270693/Intermediate-processsolution-for-the-most-voted-solution-i.e.-no-simplificationtrick-hidden
    
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        
        for(int i = 1; i <= num; i++){
            if((i & 1) == 0){
                res[i] = res[i >> 1];
            }else{
                res[i] = res[i - 1] + 1;
            }
        }
        
        return res;
    }
}