// https://leetcode.com/problems/find-all-anagrams-in-a-string

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int len = p.length();
        
        int[] arr = new int[26];
        for(char c : p.toCharArray()){
            arr[c-'a']++;
        }
        
        
        
        
        int st=0;
        for(int ed=0; ed<s.length();ed++){
            
            char c = s.charAt(ed);
            arr[c-'a']--;
            
            if(ed-st+1==len){
                    
                boolean find=true;
                
                for(int a : arr){
                    if(a!=0){
                        find=false;
                        break;
                    }
                }
                
                if(find)
                    res.add(st);
                
                arr[s.charAt(st)-'a']++;
                st++;
            }
            
            
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