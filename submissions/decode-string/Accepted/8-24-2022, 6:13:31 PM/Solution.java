// https://leetcode.com/problems/decode-string

class Solution {
    public String decodeString(String s) {
        
        
//         String res = "";
//         int idx=0, len=s.length();
//         while(st<s.length){
//             String cnt = s.substring(st, st.indexOf("["));
//             String str = s.substring(st.indexOf("[")+1, st.indexOf("]"));
//             st=
//             res += gen(cnt, s.)
            
            
            
            
//         }
//     }
    
//     private String gen(String cnt, String s){
        
//         int c = Integer.valueOf(cnt);
//         String res = "";
//         while(c>0){
//             res+=s;
//         }
        
//         return res;
//     }
        
        
        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        int k=0;
        StringBuilder sb= new StringBuilder();
        
        for(char ch : s.toCharArray()){
            
            if(Character.isDigit(ch)){
                k=k*10+ch-'0';
                
            }else if(ch=='['){
                intStack.push(k);
                strStack.push(sb);
                sb = new StringBuilder();
                 k=0;
                
            }else if(ch==']'){
                StringBuilder tmp = sb;
                sb = strStack.pop();
                for(k=intStack.pop(); k>0; k--){
                    sb.append(tmp);
                }
               
            }else{
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
                
            
            
            
                
        
        
}