// https://leetcode.com/problems/bulls-and-cows

class Solution {
    public String getHint(String secret, String guess) {
        
        int len = guess.length();
        int A=0, B=0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<len; i++){
            if(secret.charAt(i)==guess.charAt(i)){
                A++;
            }else{
                map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0)+1);
                
            }
        }
        
        for(int i=0; i<len; i++){
            if(secret.charAt(i)==guess.charAt(i)){
                continue;
            }else{
                char g = guess.charAt(i);                
                if(map.containsKey(g)){
                    map.put(g, map.get(g)-1);
                    if(map.get(g)==0)
                        map.remove(g);
                    B++;
                }
                map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0)+1);
                
            }
        }
        
        return A+"A"+B+"B";
        
    }
}