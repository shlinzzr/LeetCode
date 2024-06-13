// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii

class Solution {
    public String removeDuplicates(String s, int k) {
        int len = s.length();
        Stack<Character> st = new Stack<>();

        for(int i=0; i<len; i++){

            char ch = s.charAt(i);
            st.push(ch);
            while(i+1<len && s.charAt(i+1)==ch){
                st.push(ch);
                i++;
            }

            boolean found = false;

            if(st.size()>=k){
                Stack<Character> tmp = new Stack<>();
                int cnt = 0;
                while(st.peek()==ch){
                    tmp.push(st.pop());
                    cnt++;

                    if(cnt==k){
                        found = true;
                        break;
                    }
                }

                if(found==false){
                    while(!tmp.isEmpty()){
                        st.push(tmp.pop());
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Character a : st){
            sb.append(a);
        }

        if(sb.length()==s.length())
            return s;

     


        return removeDuplicates(sb.toString(), k);
    }
}