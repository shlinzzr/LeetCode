// https://leetcode.com/problems/roman-to-integer

class Solution {
    public int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("IX", 9);
        map.put("IV", 4);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        
        
        
        
        
        int res =0;
        
        for(Map.Entry<String, Integer> en : map.entrySet()){
            
            while(s.contains(en.getKey())){
                s = s.replace(en.getKey(), "");
                res+=en.getValue();
            }
        }
        
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        
        
        for(char c : s.toCharArray()){
            res+=map.get(String.valueOf(c));
        }
        
        
        return res;   
        
    }
}