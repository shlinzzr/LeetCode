// https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        
        if(k==0)
            return 0;
            
        
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        
        int max =0;
        
        int st=-1;
        
        for(int ed=0; ed<len; ed++){
            
            char ch = s.charAt(ed);
            
            if(map.size()==k && !map.containsKey(ch)){ // a:0
                int min=len;
                Character rm = null;
                for(Map.Entry<Character, Integer>en : map.entrySet()){
                    if(en.getValue()<min){
                        rm = en.getKey();
                        min = en.getValue();
                    }
                }
                
                // System.out.println(map.size());
                // System.out.println(ch);
                // System.out.println(min);
                // System.out.println(rm);
                st = min;
                map.remove(rm);
            }
            
            
            if(map.size()<k || map.containsKey(ch)){
                map.put(ch, ed);
                max = Math.max(max, ed-st);
                continue;
            }
            
        }
        
        return max;
        
    }
}