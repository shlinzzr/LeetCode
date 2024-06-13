// https://leetcode.com/problems/roman-to-integer

class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        
        int res =0;
        
        for(Map.Entry<String, Integer> en : map.entrySet()){
            
            int idx = s.indexOf(en.getKey());
            while(idx>=0){
                // System.out.println(en.getKey() +  " " + en.getValue());
                res+=en.getValue();
                idx = s.indexOf(en.getKey(), idx+1);
            }
            s= s.replaceAll(en.getKey(), "");
        }
        
       
        
        
        // for(char ch : s.toCharArray()){
        //     // System.out.println(ch +  " " + map.get(String.valueOf(ch)));
        //     res += map.get(String.valueOf(ch));
        // }
        
            
        return res;
    }
}
