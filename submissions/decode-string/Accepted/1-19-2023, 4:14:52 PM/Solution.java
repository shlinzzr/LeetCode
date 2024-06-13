// https://leetcode.com/problems/decode-string

class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> sst = new Stack<>();
        Stack<Integer> ist = new Stack<>();
        
        int sum=0;
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            
            
            
            if(Character.isDigit(ch)){
                sum=sum*10+(int)ch-'0'; 
            }else{
                
                if(ch=='['){
                    ist.push(sum);
                    sum=0;
                    sst.push(sb);
                    sb=new StringBuilder();
                    
                    
                }else if(ch==']'){
                    StringBuilder tmp = sb;
                    sb = sst.pop();
                    int mul = ist.pop();
                    
                    for(int i=0; i<mul; i++){
                        sb.append(tmp);
                    }
                    
                }else{
                    sb.append(ch);
                }
            }
        }
        
        return sb.toString();
        
    }
}