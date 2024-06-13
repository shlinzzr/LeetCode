// https://leetcode.com/problems/decode-string

class Solution {
    public String decodeString(String s) {
        
        Stack<StringBuilder> sst = new Stack<>();
        Stack<Integer> ist = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num=0;
        
        for(char c : s.toCharArray()){
            System.out.println(c);
            System.out.println(sb.toString());
            
            if(Character.isDigit(c)){
                num = num*10 + c-'0';
                
            }else if(c=='['){
                ist.push(num);
                sst.push(sb);
                num=0;
     
                sb = new StringBuilder();
                
            }else if(c==']'){
                StringBuilder tmp = sb;
                sb = sst.pop();
               for(num=ist.pop(); num>0; num--){
                    sb.append(tmp);
                }
                
            }else{
                sb.append(c);
            }
        }
        
        return sb.toString();
        
    }
}