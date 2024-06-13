// https://leetcode.com/problems/find-all-anagrams-in-a-string

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int len = p.length();
        
        for(int i=0; i<s.length()-len; i++){
            
            String str = s.substring(i, len+i);
            
            if(isAna(str, p))
                res.add(i);
        }
        
        return res;
        
        
        
    }
    
    private boolean isAna(String s, String p){
        
        int[] arr = new int[26];
        for(char c : p.toCharArray()){
            arr[c-'a']++;
        }
        
        for(char c : s.toCharArray()){
            arr[c-'a']--;
        }
        
        
        for(int a: arr){
            if(a!=0)
                return false;
        }
        
        return true;
    }
}