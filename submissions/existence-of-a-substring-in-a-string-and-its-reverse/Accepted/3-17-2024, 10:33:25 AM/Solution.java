// https://leetcode.com/problems/existence-of-a-substring-in-a-string-and-its-reverse

class Solution {
    public boolean isSubstringPresent(String s) {
        
        Set<String> set = new HashSet<>();
        int len = s.length();
        for(int i=0;i<len-1 ;i++){
            set.add(s.substring(i, i+2));
        }
        
        String rev = new StringBuilder(s).reverse().toString();
        
        for(String sub  : set){
            if(rev.contains(sub))
                return true;
        }
        
        return false;
        
        
        
    }
}