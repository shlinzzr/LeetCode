// https://leetcode.com/problems/smallest-subsequence-of-distinct-characters

class Solution {
    public String smallestSubsequence(String s) {
        int len = s.length();
        int[] lastOccur = new int[len];

        for(int i=0; i<len; i++){
            lastOccur[s.charAt(i)-'a'] =i;
        }

        StringBuilder sb = new StringBuilder();
        boolean[] seen = new boolean[len];


        for(int i=0; i<len ; i++){
            char ch = s.charAt(i);

            if(seen[ch-'a']) continue;


            while(sb.length()>0 && sb.charAt(sb.length()-1)>ch && lastOccur[sb.charAt(sb.length()-1)-'a']>i){
                seen[sb.charAt(sb.length()-1)-'a']=false;
                sb.deleteCharAt(sb.length()-1);
            }

            sb.append(ch);
            seen[ch-'a']=true;
        }

        return sb.toString();
    }
}