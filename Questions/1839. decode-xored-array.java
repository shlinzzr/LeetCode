// https://leetcode.com/problems/decode-xored-array

class Solution {
    public int[] decode(int[] encoded, int first) {
        
        int [] res = new int[encoded.length+1]; 
        
        
        for(int i=0; i<=encoded.length; i++){
            if(i==0){
                res[0] = first;
                continue;
            }else{
                
                // res[i-1]^res[i] = decoded[i-1];
                res[i] = res[i-1]^encoded[i-1];
            }
        }
        
        
        return res;
        
    }
}