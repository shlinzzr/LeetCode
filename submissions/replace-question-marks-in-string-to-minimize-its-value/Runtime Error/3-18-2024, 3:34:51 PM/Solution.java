// https://leetcode.com/problems/replace-question-marks-in-string-to-minimize-its-value

class Solution {
    public String minimizeStringValue(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> pos = new ArrayList<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch!='?') 
                map.put(ch, map.getOrDefault(ch,0)+1);
            else
                pos.add(i);
        }

        List<Character> list = new ArrayList<>();
        for(int p : pos){
            int min = Integer.MAX_VALUE;
            for(char ch='a'; ch<='z'; ch++){
                min = Math.min(min, map.getOrDefault(ch, 0));
            }

            for(char ch='a'; ch<='z'; ch++){
                if(map.get(ch)==min){
                    map.put(ch, map.getOrDefault(ch, 0)+1);
                    list.add(ch);
                }
            }
        }

        Collections.sort(list);
        int idx = 0;
        StringBuilder sb = new StringBuilder(s);
        for(int p : pos){
            sb.setCharAt(p, list.get(idx++));
        }

        return sb.toString();
        
    }
}