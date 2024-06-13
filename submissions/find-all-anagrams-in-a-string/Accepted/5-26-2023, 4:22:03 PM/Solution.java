// https://leetcode.com/problems/find-all-anagrams-in-a-string

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        
        
        HashMap<Character, Integer> map = new HashMap<>(); //  char , cnt;
        for(char ch : p.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        
        
        int st =0;
        
        for(int ed=0; ed<s.length(); ed++ ){
            
            char ch = s.charAt(ed);
            map.put(ch , map.getOrDefault(ch,0)-1);
            
            if(ed-st+1<p.length())
                continue;
            
            if(ed-st+1>p.length()){
                char cst = s.charAt(st);
                map.put(cst, map.getOrDefault(cst,0)+1);
                st++;
            } 
            boolean hit= true;
            for(Map.Entry<Character, Integer>en : map.entrySet()){

                if(en.getValue()!=0){
                    hit=false;
                    break;
                }
            }
            if(hit){
                res.add(st);
            }
            
           
        }
        
        return res;
        
    }
}