// https://leetcode.com/problems/reverse-string-ii

class Solution {
    public String reverseStr(String s, int k) {
        int start=0, end=k-1;
        if(end>s.length()-1)
            end = s.length()-1;
        
        char[] charArr = s.toCharArray(); 
        
        int st = start, ed=end; 
        while(st<s.length()){
            
           System.out.println(st);
                      
            while(st<ed){
                char c = charArr[st];
                charArr[st]= charArr[ed];
                charArr[ed] = c;
                st++;
                ed--;
            }
            
            st= end+k+1;
            end = end + 2*k;
            if(end>s.length()-1)
                end = s.length()-1;
            
            ed = end;
            
        }
                
                
                
        return String.valueOf(charArr);
        
        
            
            
    }
}