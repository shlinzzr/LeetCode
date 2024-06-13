// https://leetcode.com/problems/lexicographically-minimum-string-after-removing-stars

class Solution {
    public String clearStars(String s) {
        int del = 0;
        
        for(char ch : s.toCharArray()){
            if(ch=='*') del++;
        }
        
        if(del==0) return s;
        
        TreeMap<Character, Integer> map = new TreeMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='*'){
                char f = map.firstKey();
                map.put(f, map.get(f)-1 );
                if(map.get(f)==0) map.remove(f);
                
            }else{
                map.put(ch, map.getOrDefault(ch,0)+1);
            }
            
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                sb.append(ch);
                
                map.put(ch, map.get(ch)-1);
                if(map.get(ch)==0) map.remove(ch);
            }
            
            
        }
        
        return sb.toString();
    }
}