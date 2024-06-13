// https://leetcode.com/problems/remove-k-digits

class Solution {
    public String removeKdigits(String num, int k) {
        
        Stack<Integer> st = new Stack<>();
        
        int len = num.length();

        if(k==len)
            return "0";
        
        int i =0;
        while(i<len){
            
            while(k>0 && !st.isEmpty() && (num.charAt(i)-'0')<st.peek()){
                st.pop();
                k--;
            }
            
            st.push(num.charAt(i)-'0');
            i++;
        }
        
        while(k>0){
            st.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int s : st){
            sb.append(s);
        }
        
        // sb.reverse();
        
        while(!sb.isEmpty() && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
        
        
        
    }
}