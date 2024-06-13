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
        
        int sum =0;
        
        for(int i=0; i<s.length(); i++){
            
            if(i+1<s.length()){
                if( s.substring(i, i+2).equals("IX")){
                   sum+=9;
                   i++;
                }else if( s.substring(i, i+2).equals("IV")){
                   sum+=4;
                   i++;
                }else if( s.substring(i, i+2).equals("XL")){
                   sum+=50;
                   i++;
                }else if( s.substring(i, i+2).equals("XC")){
                   sum+=90;
                   i++;
                }else if( s.substring(i, i+2).equals("CD")){
                   sum+=500;
                   i++;
                }else if( s.substring(i, i+2).equals("CM")){
                   sum+=900;
                   i++;
                }else{
                    sum += map.get(s.charAt(i)+"");
                }
            }else{
                sum += map.get(s.charAt(i)+"");
            }
        }
        
        return sum;
        
        
    }
}