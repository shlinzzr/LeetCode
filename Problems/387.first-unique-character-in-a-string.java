// https://leetcode.com/problems/first-unique-character-in-a-string

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        Set<Character> deny = new HashSet<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
            if(map.get(ch)>=2)
                deny.add(ch);
        }
        
        for(int i=0; i<s.length(); i++){
            if(!deny.contains(s.charAt(i)))
                return i;
        }
        
        return -1;
        
        
    }
}
