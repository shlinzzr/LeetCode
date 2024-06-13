// https://leetcode.com/problems/first-unique-character-in-a-string

class Solution {
    public int firstUniqChar(String s) {
        int ans = -1;
        
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        HashSet<Character> set = new HashSet<>();
        
        for(int i=0; i<s.length();i++){
            
            char c = s.charAt(i);
            
            if(!map.containsKey(c)){
                
                if(!set.contains(c)){
                   map.put(c, i); 
                }
                
            }else{
                
                map.remove(c);
                set.add(c);
                
            }
        }
        
        
            
            for(Map.Entry<Character, Integer> en : map.entrySet()){
                ans = en.getValue();
                break;
            }
            
            
        
        
        return ans;
        
    }
}