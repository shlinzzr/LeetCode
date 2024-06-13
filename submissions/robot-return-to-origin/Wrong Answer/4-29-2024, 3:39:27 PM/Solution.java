// https://leetcode.com/problems/robot-return-to-origin

class Solution {
    public boolean judgeCircle(String moves) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(char ch : moves.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        
        return map.getOrDefault('U', 0) + map.getOrDefault('R', 0) -map.getOrDefault('D', 0) -map.getOrDefault('L', 0)==0;
    }
}