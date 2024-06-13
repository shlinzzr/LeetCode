// https://leetcode.com/problems/largest-substring-between-two-equal-characters

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int max= -1;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            max = Math.max(max, i-map.getOrDefault(ch, i)-1);
            map.put(ch,i);
        } 

        return max;
    }
}