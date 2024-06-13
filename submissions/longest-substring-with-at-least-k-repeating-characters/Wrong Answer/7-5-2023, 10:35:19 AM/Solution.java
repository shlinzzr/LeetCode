// https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters

class Solution {
    public int longestSubstring(String s, int k) {
        
        int len = s.length();
        
        int max= 0 ;
        
        for(int i=1; i<=26;i++){
            max = Math.max(max, helper(s, i, k));
        }
        return max;
        
    }
    
    
    private int helper(String s, int t, int k){
        
        int max = 0;
        
        HashMap<Character, Integer> map= new HashMap<>();

        int cnt = 0; // char with numbers>=k
        
        int ed=0;
        for(int st=0; st<s.length(); st++){
            
            while(ed<s.length() && map.size()<=t){
                char ch = s.charAt(ed);
                map.put(ch, map.getOrDefault(ch, 0)+1);
            
                if(map.get(ch)==k)
                    cnt++;

                if(map.size()>=t && cnt>=t){
                    max= Math.max(max, ed-st);
                }
                ed++;
            }
            
            char chh = s.charAt(st);
            
            map.put(chh, map.get(chh)-1);
            if(map.get(chh)==k-1)
                cnt--;
            
            if(map.get(chh)==0)
                map.remove(chh);
            
            
        }
        
        return max;
        
        
        
    }
}