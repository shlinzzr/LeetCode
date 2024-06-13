// https://leetcode.com/problems/ternary-expression-parser

class Solution {
    public String parseTernary(String ex) {
        System.out.println(ex);
        if(ex.length()==1)
            return ex;

        if(ex.length()==5 && ex.charAt(1)=='?' && ex.charAt(3)==':'){
            if(ex.charAt(0)=='T')
                return ex.charAt(2)+"";
            else 
                return ex.charAt(4)+"";
        }

        Stack<String> st = new Stack<>();
        int len = ex.length();


        for(int i=0; i<len; i++){
            char ch = ex.charAt(i);

            if(ch=='?'){
                int j=i-1;
                boolean fin = true;
                for(int cnt=0; i<len; i++){
                    if(ex.charAt(i)=='?') cnt++;
                    if(ex.charAt(i)==':'){
                        cnt--;
                        fin = true;
                        if(ex.charAt(i+1)=='T' || ex.charAt(i+1)=='F'){

                            
                        }
                            
                    }
                    if(cnt==0 && fin) break;
                }

                String s = parseTernary(ex.substring(j, i+2));
                System.out.println("s="+s);
                st.push(s);
            }else 
                st.push(ch+"");

            if(st.size()==5){

                String t = "";
                for(String s : st){
                    t+=s;
                }
                return parseTernary(t);
            }
        }

        return "-1";
    }
}