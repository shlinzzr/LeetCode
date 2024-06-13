// https://leetcode.com/problems/remove-k-digits

class Solution {
    public String removeKdigits(String num, int k) {

        if(k==0) return num;


        Stack<Integer> st = new Stack<>();

        int idx= 0 ;

        int len = num.length();

        if(len==k) return "0";

        while(idx<len){

            int d = num.charAt(idx++)-'0';

            while(!st.isEmpty() && st.peek()>d && k>0){
                st.pop();
                k--;
            }

            st.push(d);


            for(int a : st){
                System.out.print(a+",");
            }
            System.out.println();
        }

        while(k>0){
            st.pop();
            k--;
        }


        boolean removeLeadingZero = true;
        StringBuilder sb = new StringBuilder();
        for(int a : st){

            if(a>0){
                removeLeadingZero = false;
            }else if(removeLeadingZero && a==0)
                continue;

            sb.append(a);
        }

        if(sb.isEmpty()) return "0";

        return sb.toString();
        
    }
}