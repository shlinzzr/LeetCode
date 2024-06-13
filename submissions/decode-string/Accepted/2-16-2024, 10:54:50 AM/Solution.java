// https://leetcode.com/problems/decode-string

class Solution {
    public String decodeString(String s) {
        
        Stack<String> sst = new Stack<>();
        Stack<Integer> ist = new Stack<>();
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)){
                int num = ch-'0';
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1))){
                    num = num*10 + (s.charAt(i+1)-'0');
                    i++;
                }
                
                ist.push(num);
            }else if(ch=='['){
                sst.push(sb.toString());
                sb = new StringBuilder();
            }else if(ch==']'){
                
                StringBuilder nsb = new StringBuilder(sst.pop());
                int loop = ist.pop();
                while(loop-->0){
                    nsb.append(sb);
                }
                sb = nsb;
            }else{
                sb.append(ch);
            }
        }
        
        return sb.toString();
        
    }
}