// https://leetcode.com/problems/find-and-replace-pattern

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        
        for(String w: words){
            
            HashMap<Character, Character> map = new HashMap<>();
            HashSet<Character> set = new HashSet<>();
            
            if(w.length()!=pattern.length())
                continue;
            
            
            boolean flag =true;
            for(int i=0; i<w.length(); i++){
                
                char cw = w.charAt(i);
                char cp = pattern.charAt(i);
                
                
                if(map.containsKey(cw) && map.get(cw)!=cp){
                    flag = false;
                    continue;
                }
                    
                
                if(!map.containsKey(cw) && set.contains(cp)){
                    flag = false;
                    continue;
                }
                set.add(cp);
                map.put(cw, cp);
                
            }
            
            if(flag)
                res.add(w);
        }
        
        return res;
        
        
    }
}