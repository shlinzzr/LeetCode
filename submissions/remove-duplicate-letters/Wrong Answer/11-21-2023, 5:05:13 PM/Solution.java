// https://leetcode.com/problems/remove-duplicate-letters

class Solution {
    public String removeDuplicateLetters(String s) {
        int len = s.length();
        int[] lastOccur = new int[26];
        int[] arr = new int[26];
        for(int i=0; i<len ;i++){
            lastOccur[s.charAt(i)-'a']=i;
            arr[s.charAt(i)-'a']++;
        }



        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<len; i++){

            char ch = s.charAt(i);
            while(!st.isEmpty() && s.charAt(st.peek())>ch && lastOccur[s.charAt(st.peek())-'a']>i && arr[s.charAt(st.peek())-'a']>0){
                arr[s.charAt(st.pop())-'a']--;
            }
            st.push(i);
        }

        for(int i : st){
            sb.append(s.charAt(i));
        }

        for(int i=sb.length()-1; i>=0; i--){
            if(arr[sb.charAt(i)-'a']>1){
                arr[sb.charAt(i)-'a']--;
                sb.deleteCharAt(i);
            }
        }


        return sb.toString();
    }
}