// https://leetcode.com/problems/decode-string

class Solution {
    public String decodeString(String s) {

        Stack<Integer> ist = new Stack<>();
        Stack<StringBuilder> sst = new Stack<>();

        int len = s.length();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<len; i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                int num = ch-'0';
                while(i+1<len && Character.isDigit(s.charAt(i+1))){
                    num = num*10 + s.charAt(i+1)-'0';
                    i++;
                }

                ist.push(num);
            }else if(ch=='['){
                sst.push(sb);
                sb = new StringBuilder();
            }else if(ch==']'){

                StringBuilder tmp = new StringBuilder(sb);
                int loop = ist.pop();
                sb = sst.pop();
                while(loop-->0){
                    sb.append(tmp);
                }

            }else{
                sb.append(ch);
            }
        }

        return sb.toString();

        
    }
}