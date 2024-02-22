// https://leetcode.com/problems/minimum-window-substring

class Solution {
    public String minWindow(String s, String t) {
        
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        
        int min = Integer.MAX_VALUE;
        String res = "";
        int st =0;
        
        for(int ed =0; ed<s.length(); ed++){
            char ch = s.charAt(ed);
            
            if(!map.containsKey(ch)){
                continue;
            }
            
            map.put(ch, map.get(ch)-1);
            
            if(!isValid(map)) continue;
            
            while(st<=ed && isValid(map)){
                if(ed-st+1 < min){
                    res = s.substring(st ,ed+1);
                    min = ed-st+1;
                }
                
                char chst = s.charAt(st);
                if(map.containsKey(chst)){
                    map.put(chst, map.get(chst)+1);
                }
                st++;
            }
            
            
        }
        
        return res;
    }
    
    private boolean isValid(Map<Character, Integer> map){
        for(int v : map.values()){
            if(v>0) return false; 
        }
        
        return true;
    }
}