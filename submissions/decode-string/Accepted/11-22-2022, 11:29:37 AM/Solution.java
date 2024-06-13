// https://leetcode.com/problems/decode-string

class Solution {
    public String decodeString(String s) {
        
        
        StringBuilder sb = new StringBuilder();
        Stack<Integer> ist = new Stack<>();
        Stack<StringBuilder> sst = new Stack<>();
        int num = 0;
        for(char ch : s.toCharArray()){
            
            if(Character.isDigit(ch)){
                num = num*10 + (ch-'0');
                
            }else if(ch=='['){
                ist.push(num);
                num=0;
                sst.push(sb);
                sb= new StringBuilder();
                
            }else if(ch==']'){
                
                StringBuilder tmp = sb;
                sb = sst.pop();
                for(int i=ist.pop(); i>0; i--){
                    sb.append(tmp);
                }
                
                
            }else{
                sb.append(ch);
            }
        }
        
        return sb.toString();
        
    }
}