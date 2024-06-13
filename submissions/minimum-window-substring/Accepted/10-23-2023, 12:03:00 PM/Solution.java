// https://leetcode.com/problems/minimum-window-substring

class Solution {
    public String minWindow(String s, String t) {
        
        HashMap<Character, Integer> map  = new HashMap<>();
        for(char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        String res = "";
        int min = Integer.MAX_VALUE;

        int st =0;
        for(int ed=0; ed<s.length(); ed++){
            char ch = s.charAt(ed);
            map.put(ch, map.getOrDefault(ch,0)-1);

            if(ed-st+1<t.length())
                continue;

            while(st<=ed && isValid(map)){

                if(ed-st+1<min){
                    min = ed-st+1;
                    res = s.substring(st, ed+1);
                }

                char chst = s.charAt(st);
                map.put(chst, map.getOrDefault(chst, 0)+1);
                st++;
            }


        }

        return res;

    }


    private boolean isValid(HashMap<Character, Integer> map ){
        for(char ch : map.keySet()){
            if(map.get(ch)>0)
                return false;
        }
        return true;
    }
}