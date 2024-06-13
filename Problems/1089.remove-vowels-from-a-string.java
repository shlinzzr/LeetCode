// https://leetcode.com/problems/remove-vowels-from-a-string

class Solution {
    public String removeVowels(String s) {
        String res = "";
        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        for(char ch : s.toCharArray()){
            if(set.contains(ch)) continue;
            res+=ch;
        }

        return res;
    }
}