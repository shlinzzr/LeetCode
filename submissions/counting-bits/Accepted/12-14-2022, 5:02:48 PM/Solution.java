// https://leetcode.com/problems/counting-bits

class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        
        for(int i=1; i<=n ;i++){
            String bin = Integer.toBinaryString(i);
            
            for(char ch : bin.toCharArray()){
                if(ch=='1')
                    res[i] ++ ;
            }
            
        }
        
        return res;
        
    }
}