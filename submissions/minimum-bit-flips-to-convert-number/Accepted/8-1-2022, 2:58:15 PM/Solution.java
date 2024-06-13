// https://leetcode.com/problems/minimum-bit-flips-to-convert-number

class Solution {
    public int minBitFlips(int start, int goal) {
        
        
        String stStr = intToBinaryStr(start);
        String edStr = intToBinaryStr(goal);
            
        int max = Math.max(stStr.length(), edStr.length());
        
        while(stStr.length()<max){
            stStr = "0" + stStr;
        }
        
        while(edStr.length()<max){
            edStr = "0" + edStr;
        }
            
            
//         System.out.println(stStr);
        
//         System.out.println(edStr);
        int c =0;
        
        int len = Math.min(stStr.length(), edStr.length());
        
        for(int i=0; i<len; i++){
            if(stStr.charAt(i)!=edStr.charAt(i))
                c++;
        }        
        return c;
    }
    
    
    private String intToBinaryStr(int num){
        String res = "";
        int mod = 1;
        while(num>0){
            res = (num %2==0 ? "0" :  "1") + res;
            num /=2;
        }
        
        return res;
    }
}
