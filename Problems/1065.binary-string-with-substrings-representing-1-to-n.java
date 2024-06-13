// https://leetcode.com/problems/binary-string-with-substrings-representing-1-to-n

class Solution {
    public boolean queryString(String s, int n) {
        
        for(int i=n; i>=n/2&&i>0; i--){
            String bin = Integer.toBinaryString(i);
            // System.out.println("bin="+bin);
            if(s.indexOf(bin)==-1) return false;
        }
        
        return true;
        
        
    }
}


// 8421
 // 7=0111
 //     6=0110
 //     5=0101
 //     4=0010