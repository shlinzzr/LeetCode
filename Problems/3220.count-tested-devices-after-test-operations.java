// https://leetcode.com/problems/count-tested-devices-after-test-operations

class Solution {
    public int countTestedDevices(int[] bp) {
        int len = bp.length;
        
        int t=0;
        int dec =0;
        for(int i=0; i<len; i++){
            if(bp[i]-dec>0){
                t++;
                dec++;
            }
        }
        
        return t;
    }
}