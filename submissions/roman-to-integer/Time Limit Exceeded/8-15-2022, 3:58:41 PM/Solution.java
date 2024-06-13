// https://leetcode.com/problems/roman-to-integer

class Solution {
    public int romanToInt(String s) {
        String sym = "IVXLCDM";
        HashMap<String, Integer> map = new HashMap<>();
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        int curr = 0;
        for(Map.Entry<String, Integer> en : map.entrySet()){
            String key = en.getKey();
            int val = en.getValue();
            
            while(s.indexOf(key)>=0){
                s.replace(key, "");
                curr+=val;
            }
        }
       
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            switch (c){
                case 'I':
                    curr+=1;
                    break;
                    
                case 'V':
                    curr+=5;
                    break;
                    
                case 'X':
                    curr+=10;
                    break;
                    
                case 'L':
                    curr+=50;
                    break;
                    
                case 'C':
                    curr+=100;
                    break;
                    
                case 'D':
                    curr+=500;
                    break;
                    
                case 'M':
                    curr+=1000;
                    break;
            }            
        }
        
        return curr;
        
    }
}