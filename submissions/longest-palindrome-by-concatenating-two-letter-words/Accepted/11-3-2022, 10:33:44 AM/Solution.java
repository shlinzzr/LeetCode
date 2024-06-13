// https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words

class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String ,Integer> map = new HashMap<>();
        int max=0;
        for(String w : words){
            
            String rev = w.charAt(1)+""+w.charAt(0);
            if(map.containsKey(rev)){
                max+=4;
                map.put(rev, map.get(rev)-1);
                if(map.get(rev)==0)
                    map.remove(rev);
            }else{
                map.put(w, map.getOrDefault(w, 0)+1);                
            }
        }
        
        for(String k : map.keySet()){
            
            if(map.get(k)==1 && k.charAt(0)==k.charAt(1)){
                max+=2;
                break;
            }
        }
        
        return max;
    }
}