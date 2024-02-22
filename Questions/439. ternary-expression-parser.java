// https://leetcode.com/problems/ternary-expression-parser

class Solution {
    public String parseTernary(String ex) {
        
        Stack<String> st = new Stack<>();
        
        String cur = "";
        
        int len = ex.length();
        
        for(int i=0; i<len; i++){
            
            if(i+1<len && ex.charAt(i+1)=='?'){
                st.push(cur);
                cur = ex.charAt(i) +"";
                
                
            }else{
                cur += ex.charAt(i);
                while(cur.length()==5){
                    cur = helper(cur);
                    cur = st.pop() + cur ;
                }
            }
        }
        
        return cur;
        
    }
    
    private String helper(String str){
        
        if(str.charAt(0)=='T'){
            return str.charAt(2)+"";
        }
        return str.charAt(4)+"";
    }
}