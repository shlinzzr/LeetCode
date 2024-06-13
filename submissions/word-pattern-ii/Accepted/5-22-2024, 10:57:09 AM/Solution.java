// https://leetcode.com/problems/word-pattern-ii

class Solution {
    public boolean wordPatternMatch(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
    
        return isMatch(s, 0, pattern, 0, map, set);
    }

    private boolean isMatch(String str, int i, String pat, int j, Map<Character, String> map, Set<String> set){ 
        // base case
        int slen = str.length();
        int plen = pat.length();

        if (i == slen && j == plen) return true;
        if (i == slen || j == plen) return false;
        
        // get current pattern character
        char ch = pat.charAt(j);
        
        // if the pattern character exists
        if (map.containsKey(ch)) {
            String s = map.get(ch);
            
            // then check if we can use it to match str[i...i+s.length()]
            if (!str.startsWith(s, i)) {
                return false;
            }
            
            // if it can match, great, continue to match the rest
            return isMatch(str, i + s.length(), pat, j + 1, map, set);

        }else{ // pattern character does not exist in the map

            for (int k = i; k < str.length(); k++) {
                String p = str.substring(i, k + 1);

                if (set.contains(p)) {
                    continue;
                }

                // create or update it
                map.put(ch, p);
                set.add(p);
                
                // continue to match the rest
                if (isMatch(str, k + 1, pat, j + 1, map, set)) {
                    return true;
                }

                // backtracking
                map.remove(ch);
                set.remove(p);
            }
            
        }
        
       
        // we've tried our best but still no luck
        return false;
  }
}