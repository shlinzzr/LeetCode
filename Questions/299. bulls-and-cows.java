// https://leetcode.com/problems/bulls-and-cows

class Solution {
    public String getHint(String secret, String guess) {
        
        int b = 0;
        
        int len = secret.length();
        boolean[] seen = new boolean[len];
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        
        for(int i=0; i<len; i++){
            if(secret.charAt(i)==guess.charAt(i)){
                b++;
                seen[i]=true;
            }else{
                char ch = secret.charAt(i);
                map.put(ch , map.getOrDefault(ch,0)+1);
            }
        }
        
        
        int c = 0;
        for(int i=0; i<len; i++){
            if(seen[i])
                continue;
            
            char ch = guess.charAt(i);
            if(map.containsKey(ch) && map.get(ch)>0){
                c++;
                map.put(ch, map.get(ch)-1);
            }
        }
        
        return b+"A"+c+"B";
        
    }
}