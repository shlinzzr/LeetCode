// https://leetcode.com/problems/remove-k-digits

class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();


        if(k==len)
            return "0";
        
        Stack<Character> stk = new Stack<>();



        for(int i=0; i<len; i++){
            char ch = num.charAt(i);

            while(!stk.isEmpty() &&  k>0 && ch<stk.peek() ){
                stk.pop();
                k--;
            }
            stk.push(ch);
        }

        while(/*!stk.isEmpty() &&*/ k>0){
            stk.pop();
            k--;
        }

        String res = "";
        for(char ch : stk){
            if(res.isEmpty() && ch=='0')
                continue;
            res += ch;
        }

        return res.isEmpty() ? "0" : res;

    }
}