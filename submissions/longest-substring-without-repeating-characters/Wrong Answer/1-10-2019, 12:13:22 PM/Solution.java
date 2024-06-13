// https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Character c = null;
        List<Character> ac = new ArrayList<Character>();
        int max = 0, start_idx = 0;
        
        for(int i=0; i<s.length(); i++){
            
            for(int j=i; j<s.length(); j++){
                c = s.charAt(j);
                System.out.println(c);
                
                if(c.equals("")) continue;
                
                /*
                  The size of an array can't be modified. 
                  A better solution would be to use an ArrayList which can grow as you need it. 
                */
                
                if(!ac.contains(c)){
                    ac.add(c);
                    
                }else{
                    max = Math.max(max, ac.size());
                    ac.clear();
                    break;
                }
            
            }
            
        }
 
        return max;
    }
 
}