// https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string

class Solution {
    public String robotWithString(String s) {

        int[] arr = new int[26];
        for(char ch : s.toCharArray()){
            arr[ch-'a']++;
        }

        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()){


            while(!st.isEmpty() && st.peek() <= getMinChar(arr)){
                char p = st.pop();
                arr[p-'a']--;
                sb.append(p);
            }

            st.push(ch);
        }

        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.toString();

        
    }

    private char getMinChar(int[] arr){
        for(int i=0; i<26; i++){
            if(arr[i]!=0) return (char)('a'+i);
        }

        return 'z';
    }
}