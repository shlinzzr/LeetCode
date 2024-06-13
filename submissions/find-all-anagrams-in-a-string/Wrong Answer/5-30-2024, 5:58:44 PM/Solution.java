// https://leetcode.com/problems/find-all-anagrams-in-a-string

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();

        Map<Character, Integer> map_p= new HashMap<>();
        for(char ch : p.toCharArray()){
            map_p.put(ch, map_p.getOrDefault(ch, 0)+1);
        }

        int st= 0 ;
        Map<Character, Integer> map_s = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(map_p.containsKey(ch)){
                map_s.put(ch, map_s.getOrDefault(ch, 0)+1);
            }else{
                continue;
            }

            if(i-st+1<p.length()) continue;

            while(i-st+1>=p.length()){

                if(i-st+1==p.length() && isAna(map_p, map_s)){
                    res.add(st);
                }

                char chh = s.charAt(st);

                if(map_s.containsKey(chh)){
                    map_s.put(chh, map_s.get(chh)-1);
                    if(map_s.get(chh)==0){
                        map_s.remove(chh);
                    }
                }
                st++;
            }
        }
        return res;
    }

    private boolean isAna(Map<Character, Integer> map_p, Map<Character, Integer> map_s ){

        if(map_p.size()!=map_s.size()) return false;
        
        for(char key : map_p.keySet()){
            if(!map_s.containsKey(key)) return false;
            if(map_s.get(key) != map_p.get(key)) return false;
        }

        return true;
    }
}