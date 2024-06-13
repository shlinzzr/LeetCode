// https://leetcode.com/problems/to-lower-case

class Solution {
    public String toLowerCase(String s) {
//         char a = 'a';
//         char A = 'A';
        
//         System.out.println((int) A);
//         return "";
        
//         // a 97
//         // A 65
        
        
        String res = "";
        for(char c : s.toCharArray()){
            
            if(c>='A' && c<='Z')
                res +=  (char) (c-'A'+'a');
            else 
                res += c;
            
            
            
        }
        
        return res;
        
    }
}