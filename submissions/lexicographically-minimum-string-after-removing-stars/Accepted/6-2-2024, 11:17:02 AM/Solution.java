// https://leetcode.com/problems/lexicographically-minimum-string-after-removing-stars

class Solution {
    public String clearStars(String s) {
        int del = 0;
        
        for(char ch : s.toCharArray()){
            if(ch=='*') del++;
        }
        
        
        if(del==0) return s;
        
        boolean[] bool = new boolean[s.length()];
        Arrays.fill(bool, true);
        
        TreeMap<Character, List<Integer>> map = new TreeMap<>();
        // Map<Integer, Integer> imap = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='*'){
                
                // System.out.println(map);
                
                char f = map.firstKey();
                int idx = map.get(f).remove(map.get(f).size()-1);
                if(map.get(f).size()==0) map.remove(f);
                bool[idx]=false;
                
                
            }else{
                // imap.put(ch, i);
                map.putIfAbsent(ch, new ArrayList<>());
                map.get(ch).add(i);
            }
            
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch) && bool[i]){
                sb.append(ch);
                
                
                // map.put(ch, map.get(ch)-1)
                // if(map.get(ch)==0) map.remove(ch);
            }
            
            
        }
        
        return sb.toString();
    }
}