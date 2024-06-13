// https://leetcode.com/problems/minimum-window-substring

class Solution {
    public String minWindow(String s, String t) {
        
        if(s.equals(t))
            return s;
        
        
        int[] arr = new int[52];
        
        int m = s.length();
        int n = t.length();
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        
        
        for(char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        
        String res = "";
        int min = Integer.MAX_VALUE;
        
        int st=0;
        for(int ed=0; ed<m; ed++){
            char ch = s.charAt(ed);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
            }
            
            while(st<ed && isValid(map)){
                
                if(ed-st+1<min){
                    min = Math.min(min, ed-st+1);
                    res = s.substring(st, ed+1);
                }
                char chh = s.charAt(st);
                
                if(map.containsKey(chh)){
                    map.put(chh, map.get(chh)+1);
                }
                st++;
            }
            
        }
        
        return res;
        
        
        
        
        
        
        
    }
    
    
    private boolean isValid(HashMap<Character, Integer> map){
        
        for(Map.Entry<Character, Integer> en : map.entrySet()){
            if(en.getValue()>0)
                return false;                
        }
        
        return true;
        
    }
    
    
//     private boolean isValid(int[] arr){
        
//         for(a : arr){
//             if(a>0)
//                 return false;
//         }
        
//         return true;
        
//     }
}