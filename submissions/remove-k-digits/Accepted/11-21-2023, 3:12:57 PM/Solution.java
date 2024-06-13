// https://leetcode.com/problems/remove-k-digits

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack<>();
        

        int len = num.length();

        if(k>=len)
            return "0";

        for(int i=0; i<len; i++){
            char ch = num.charAt(i);

            while(k>0 && !st.isEmpty() && num.charAt(st.peek())>num.charAt(i)){
                st.pop();
                k--;
            }

            st.push(i);
        }

        while(k>0){
            st.pop();
            k--;
        }


        String res = "";
        for(int i : st){
            if(res.isEmpty() && num.charAt(i)=='0')
                continue;
            res+=num.charAt(i);
        }

        return res.isEmpty()? "0" : res;
    }
}