// https://leetcode.com/problems/decode-string

class Solution {
    public String decodeString(String s) {
        int len = s.length();
        Stack<Integer> ist = new Stack<>();
        Stack<StringBuilder> sst = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num=0;
        for(int i=0; i<len; i++){
            
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                 num = ch-'0';
                while(i<len && Character.isDigit(s.charAt(i+1))){
                    num=num*10 + s.charAt(i+1)-'0';
                    i++;
                }
                
            }else if(ch=='['){
                
                ist.push(num);
                sst.push(sb);
                num=0; 
                sb = new StringBuilder();
                
            }else if(ch==']'){
                
                StringBuilder tmp = sb;
                int rp = ist.pop();
                sb = sst.pop();
                for(int r=0; r<rp; r++){
                    sb.append(tmp);
                }
            }else{
                sb.append(ch);
            }
            
           
                
            
        }
        
        return sb.toString();
            
        
    }
}