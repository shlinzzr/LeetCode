// https://leetcode.com/problems/minimum-window-substring

class Solution {
    public String minWindow(String s, String t) {

        if(s.length()<t.length()) return "";
        
        Map<Character, Integer> map = new HashMap<>();
        for( char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int st = 0 ;
        int left = 0;
        int wordLen = s.length()+1;
        int counter = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(!map.containsKey(ch)) continue;

            map.put(ch, map.get(ch)-1);
            if(map.get(ch)>=0) counter++;

            if(!isValid(map))  continue;

            

            while(counter==t.length()){

                if(i-st+1 < wordLen){
                    left = st;
                    wordLen = i-st+1;
                }

                char chst = s.charAt(st);
                if(map.containsKey(chst)){
                    map.put(chst, map.get(chst)+1);
                    if(map.get(chst)>0) counter--;  
                }
                st++;
            }
        }

        return wordLen == s.length()+1 ? "" : s.substring(left, left+ wordLen);

        
    }

    private boolean isValid(Map<Character, Integer> map){
        // for(char ch : map.keySet()){
        //     if(map.get(ch)>0) return false;
        // }
        return true;
    }
}