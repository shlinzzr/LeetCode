// https://leetcode.com/problems/remove-duplicate-letters

class Solution {
    public String removeDuplicateLetters(String s) {
        int len = s.length();
        int[] lastOccur = new int[26];
        for(int i=0; i<len ;i++){
            lastOccur[s.charAt(i)-'a']=i;
        }

        boolean[] seen = new boolean[26];
       
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<len; i++){

            char ch = s.charAt(i);
            if(seen[ch-'a']) continue;

            while(!st.isEmpty() && s.charAt(st.peek())>ch && lastOccur[s.charAt(st.peek())-'a']>i ){       
                seen[s.charAt(st.pop())-'a']=false;
            }
            seen[ch-'a']=true;
            st.push(i);
        }


        StringBuilder sb = new StringBuilder();
        for(int i : st){
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}