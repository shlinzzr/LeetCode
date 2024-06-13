// https://leetcode.com/problems/word-pattern

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] sa = s.split(" ");
        
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        
        int len = pattern.length();
        if(len!=sa.length)
            return false;
        
        for(int i=0; i<pattern.length(); i++){
            char ch = pattern.charAt(i);
            
            if(map.containsKey(ch)){
                if(!map.get(ch).equals(sa[i]))
                    return false;
            }else if(set.contains(sa[i])){
                return false;
                
            }else{
                map.put(ch, sa[i]);
                set.add(sa[i]);
            }
            
        }
        return true;
    }
    
}