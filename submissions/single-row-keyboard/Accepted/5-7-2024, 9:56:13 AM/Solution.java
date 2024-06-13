// https://leetcode.com/problems/single-row-keyboard

class Solution {
    public int calculateTime(String keyboard, String word) {
        
        int dis = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<keyboard.length(); i++){
            map.put(keyboard.charAt(i), i);
        }
        
        if(word.length()==1){
            return map.get(word.charAt(0));
        }
        
        for(int i=0; i<word.length()-1; i++){
            
            int a = map.get(word.charAt(i));
            int b = map.get(word.charAt(i+1));
            
            if(dis==0) dis+=a;
            
            dis += Math.abs(a-b);
            
        }
        
        return dis;
        
    }
}