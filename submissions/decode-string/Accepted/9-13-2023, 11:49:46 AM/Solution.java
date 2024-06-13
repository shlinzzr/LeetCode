// https://leetcode.com/problems/decode-string

class Solution {
    public String decodeString(String s) {
        int len = s.length();
        Stack<Integer> ist = new Stack<>();
        Stack<StringBuilder> sst = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<len; i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                int num = ch-'0';
                while(i+1<len && Character.isDigit(s.charAt(i+1))){
                    num = num*10 + (s.charAt(i+1)-'0');
                    i++;
                }

                ist.push(num);
                continue;
            }else if(ch =='['){
                sst.push(new StringBuilder(sb));
                sb = new StringBuilder();

            }else if(ch==']'){
                int times = ist.pop();
                StringBuilder prev = sst.isEmpty() ? new StringBuilder() : sst.pop();
                for(int j=0; j<times; j++){
                    prev.append(sb);
                }
                sb = prev;
            }else{
                sb.append(ch);
            }

        }


        return sb.toString();

      
            
        
    }
}