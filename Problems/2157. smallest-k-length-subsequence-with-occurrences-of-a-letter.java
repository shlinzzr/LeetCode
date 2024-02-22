// https://leetcode.com/problems/smallest-k-length-subsequence-with-occurrences-of-a-letter

class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        int del0 = s.length()-k;

        int letterCnt = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==letter)
                letterCnt++;
        }
        int del1 = letterCnt-repetition;


        Stack<Character> stk = new Stack<>();

        for(int i=0; i<s.length(); i++){
            while(!stk.isEmpty() && s.charAt(i)<stk.peek() && del0>0 && (stk.peek()!=letter || (stk.peek()==letter && del1>0))){
                if(stk.peek()==letter){
                    del1--;
                }
                del0--;
                stk.pop();
            }
            stk.push(s.charAt(i));
        }


        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }

        StringBuilder res = new StringBuilder();
        for(int i=0; i<sb.length(); i++){
            char ch = sb.charAt(i);

            // if(del0==0 || (ch==letter && del1==0)){
            //     res.append(ch);
            // }else{
            //     del0--;
            //     if(ch==letter)
            //         del1--;
            // }

            if(ch==letter && del1>0 && del0>0){
                del1--;
                del0--;
                continue;
            }else if(ch!=letter && del0>0){
                del0--;
                continue;
            }
            res.append(ch);
        }

        return res.reverse().toString();


    }
}