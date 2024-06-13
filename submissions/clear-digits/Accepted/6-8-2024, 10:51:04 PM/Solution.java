// https://leetcode.com/problems/clear-digits

class Solution {
    public String clearDigits(String s) {
        
        
        
        
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)){
                st.pop();
            }else 
                st.push(ch);
        }
        String res= "";
        for(char ch : st){
            res += ch;
        }
        
        return res;
        
//         int len = s.length();
        
//         boolean[] del = new boolean[len];
//         for(int i=0; i<len; i++){
//             char ch = s.charAt(i);
            
//             if(Character.isDigit(ch)){
//                 for(int j=i-1; j>=0; j--){
//                     char chj = s.charAt(j);
//                     if(!Character.isDigit(chj)){
//                         del[j]=true;
//                         del[i]=true;
//                         break;
//                     }
//                 }
//             }
//         }
//         StringBuilder sb = new StringBuilder();
        
//         for(int i=0; i<len; i++){
//             if(del[i]==false) sb.append(s.charAt(i));
//         }
        
//         return sb.toString();
        
    }
}