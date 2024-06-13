// https://leetcode.com/problems/minimum-window-substring

class Solution {
    public String minWindow(String s, String t) {

        int sLen = s.length();
        int tLen = t.length();

        Map<Character, Integer> tmap = new HashMap<>();
        for(int i=0; i<tLen; i++){
            char ch = t.charAt(i);
            tmap.put(ch, tmap.getOrDefault(ch, 0)+1);
        }


        Map<Character, Integer> smap = new HashMap<>();
        String res = "";
        int st =0 , min=sLen+1;
        for(int i=0; i<sLen; i++){

            char ch = s.charAt(i);
            smap.put(ch, smap.getOrDefault(ch,0)+1);
            
            if(!tmap.containsKey(ch)) continue;
            if(smap.size()<tmap.size()) continue;
            if(smap.get(ch)<tmap.get(ch)) continue;

            min = Math.min(min, i-st+1);

            while(isOk(smap, tmap)){
                res = s.substring(st, i+1);
                char chh = s.charAt(st);
                smap.put(chh, smap.get(chh)-1);
                st++;
            }

        }

        return min==sLen+1 ?  "" : res;
        
    }

    private boolean isOk(Map<Character, Integer> smap, Map<Character, Integer> tmap){

        for(char ch : tmap.keySet()){
            if(smap.getOrDefault(ch,0)<tmap.get(ch)) return false;
        }
        return true;
    }
}
