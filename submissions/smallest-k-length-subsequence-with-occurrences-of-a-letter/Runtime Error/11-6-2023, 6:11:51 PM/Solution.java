// https://leetcode.com/problems/smallest-k-length-subsequence-with-occurrences-of-a-letter

class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        
        int k0 = s.length() - k; // # of total char can delete

        int cnt =0 ;
        for(char ch : s.toCharArray()){
            if(ch==letter)
                cnt++;
        }
        int k1 = cnt-repetition; // # of "letter" can delete

        int cnt0 = 0;
        int cnt1 = 0;
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            while(!st.isEmpty() && ch<st.peek() && cnt0<k0 && (st.peek()!=letter || (st.peek()==letter && cnt1<k1))){
                if(st.peek()==letter)
                    cnt1++;
                st.pop();
                cnt0++;
               
            }

            st.push(ch);
        }


        StringBuilder sb = new StringBuilder();
        for(char ch : st){
            sb.append(ch);
        }

        int delIdx = sb.length()-1;
        while(sb.length()>k){
            while(cnt1==k1 && sb.charAt(delIdx)==letter){
                delIdx--;
            }
            sb.deleteCharAt(delIdx);
        }

        return sb.toString();

        
    }
}