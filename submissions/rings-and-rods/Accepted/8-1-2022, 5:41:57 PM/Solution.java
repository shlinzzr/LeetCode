// https://leetcode.com/problems/rings-and-rods

class Solution {
    public int countPoints(String rings) {
        HashMap<Character, String> map = new HashMap<>();
        
        for(int i=0; i<rings.length(); i+=2){
            
            char color = rings.charAt(i);
            char idx = rings.charAt(i+1);
            if(map.get(idx)==null){
                map.put(idx, color+"");
                
            } else {
                String s = map.get(idx);
                if(!s.contains(color+"")){
                    map.put(idx, s+color);
                }
            }
        }
        
        
        int cnt=0;
        for(Map.Entry<Character, String> en : map.entrySet()){
            if(en.getValue().length()==3)
                cnt++;
            // System.out.println(en.getKey() + " " + en.getValue() );
        }
        
        return cnt;
        
    }
}