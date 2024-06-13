// https://leetcode.com/problems/longest-repeating-character-replacement

class Solution {
    public int characterReplacement(String s, int k) {
        
        int len = s.length();
        
        HashMap<Character, Integer> map = new HashMap<>();
        int max=0;
        
        int st =0;
        
        for(int ed=0; ed<len; ed++){
            
            char ch = s.charAt(ed);
            map.put(ch, map.getOrDefault(ch,0)+1);
            
            
            if(map.size()==1){
                max = Math.max(max, ed-st+1);
                
                
            }else if(map.size()<=2){
                boolean flag = false;
                
                for(int v : map.values()){
                    if(v<=k)
                        flag=true;
                }
                
                if(flag)
                    max = Math.max(max, ed-st+1);
            }            
            
            while(map.size()>2){
                
                char chh = s.charAt(st);
                map.put(chh, map.get(chh)-1);
                
                if(map.get(chh)==0)
                    map.remove(chh);
                st++;
            }
        }
        
        return max;
        
    }
}