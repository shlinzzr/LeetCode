// https://leetcode.com/problems/valid-palindrome

class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if((ch>='a' && ch<='z') || (ch>='0' && ch<='9'))
                sb.append(ch);

            else if(ch>='A' && ch<='Z'){
                sb.append((char) ('a'+(ch-'A')));
            }
        }

        for(int i=0; i<sb.length()/2; i++){
            if(sb.charAt(i) != sb.charAt(sb.length()-1-i))
                return false;
        }

        return true;
    }
}