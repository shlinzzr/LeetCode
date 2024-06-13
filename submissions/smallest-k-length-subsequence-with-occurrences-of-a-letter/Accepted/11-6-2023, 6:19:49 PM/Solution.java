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
            while(!st.isEmpty() && s.charAt(i)<st.peek() && cnt0<k0 && (st.peek()!=letter || (st.peek()==letter && cnt1<k1))){
                if(st.peek()==letter)
                    cnt1++;
                st.pop();
                cnt0++;
               
            }

            st.push(s.charAt(i));
        }

        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
            sb.append(st.pop());

        StringBuilder res = new StringBuilder();
        for(int i=0; i<sb.length(); i++){
            if(cnt0==k0 || (sb.charAt(i)==letter && cnt1==k1)){
                res.append(sb.charAt(i));
            }else{
                cnt0++;
                if(sb.charAt(i)==letter)
                    cnt1++;
            }
        }


        return res.reverse().toString();

        
    }
}