// https://leetcode.com/problems/student-attendance-record-i

class Solution {
    public boolean checkRecord(String s) {
        int absent = 0;
        
        int len = s.length();
        for(int i=0; i<len-2; i++){
            
            int a = s.charAt(i);
            int b = s.charAt(i+1);
            int c = s.charAt(i+2);
            
            if(a=='L' && b=='L' && c=='L') return false;
            
        }
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='A') absent++;
        }
        
        
        return absent<2;
    }
}