// https://leetcode.com/problems/minimum-window-substring

class Solution {
    public String minWindow(String s, String t) {

        int len_s = s.length();
        int len_t = t.length();

        Map<Character, Integer> map_t = new HashMap<>();
        for(char ch : t.toCharArray()){
            map_t.put(ch, map_t.getOrDefault(ch,0)+1);
        }

        int min = s.length()+1;
        String res= "";
        Map<Character, Integer> map_s = new HashMap<>();
        int st=0;
        for(int i=0; i<len_s; i++){
            char ch = s.charAt(i);
            map_s.put(ch, map_s.getOrDefault(ch, 0)+1);
            
            boolean vd = isValid(map_s, map_t);
            // System.out.println(i + " " + vd);
            // System.out.println(map_s);
            // System.out.println(map_t);
            if(!vd) continue;

            while(vd){
                
                if(i-st+1<min){
                    min = Math.min(min, i-st+1);
                    res = s.substring(st, st+min);
                }

                char chst = s.charAt(st);
                map_s.put(chst, map_s.get(chst)-1);
                if(map_s.get(chst)==0) map_s.remove(chst);
                st++;
                vd = isValid(map_s, map_t);
            }
        }
        return res;
    }

    private boolean isValid(Map<Character, Integer> s, Map<Character, Integer> t){

        if(s.size()<t.size()) return false;
        for(char k : t.keySet()){
            if(!s.containsKey(k)) return false;
            if(s.get(k)<t.get(k)) return false;
        }
        return true;
    }
}