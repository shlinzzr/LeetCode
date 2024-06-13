// https://leetcode.com/problems/longest-repeating-character-replacement

class Solution {
    public int characterReplacement(String s, int k) {

        int len = s.length();

        Map<Character, Integer> map = new HashMap<>();
        int max=0;
        int st=0;
        for(int i=0; i<len; i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);

            while(getDiff(map)>k){
                char chst = s.charAt(st);
                map.put(chst, map.get(chst)-1);
                if(map.get(chst)==0)
                    map.remove(chst);
                st++;
            }

            max = Math.max(max, i-st+1);
        }

        return max;
        
    }

    private int getDiff(Map<Character, Integer> map){

        if(map.size()==1) return 0;

        int max = 0 ;
        char ch = 'a';
        for(char key : map.keySet()){
            
            if(map.get(key)>max){
                max = map.get(key);
                ch = key;
            }
            
        }
        int diff = 0 ;
        for(char key : map.keySet()){
            if(key!=ch){
                diff += map.get(key);
            }
        }

        return diff;
    }
}