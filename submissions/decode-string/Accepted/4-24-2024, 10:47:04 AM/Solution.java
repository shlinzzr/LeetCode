// https://leetcode.com/problems/decode-string

class Solution {
    public String decodeString(String s) {
        
        Stack<StringBuilder> sst = new Stack<>();
        Stack<Integer> ist = new Stack<>();
        
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<len; i++){
            char ch = s.charAt(i);
            if(ch==' ') continue;
            
            if(Character.isDigit(ch)){
                int num = ch-'0';
                while(i+1<len && Character.isDigit(s.charAt(i+1))){
                    num = num*10 + (s.charAt(i+1)-'0');
                    i++;
                }
                ist.push(num);
                
            }else if(ch == '['){
                sst.push(sb);
                sb = new StringBuilder();
            }else if(ch==']'){
                String temp = sb.toString();
                int loop = ist.pop();
                sb = sst.pop();
                while(loop-->0){
                    sb.append(temp);
                }
            }else{
                sb.append(ch);
            }
        }
        
        return sb.toString();
        
    }
}