// https://leetcode.com/problems/partition-string-into-minimum-beautiful-substrings

class Solution {
    public int minimumBeautifulSubstrings(String s) {
        // 1
        // 101 : 5
        // 16 8 4 2 1 : 11001
        // 1111101          
        // 1001110001
        // 11 00001 10101
        // 1111 01000 01001
        // 10 01100 01001 01101
        
        String[] arr = new String[]{ "11110100001001", "110000110101",  "1001110001" , "1111101" , "11001", "101" , "1"};
        
        int cnt  =0;
        for(String a : arr){
            
            
            if(s.startsWith(a)){
                s=s.replace(a, "");
                cnt++;
            }
        }
        
        
        return cnt==0?  -1 : cnt;
    }
}