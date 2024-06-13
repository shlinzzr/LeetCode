// https://leetcode.com/problems/find-all-anagrams-in-a-string

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>  res = new ArrayList<>();
        
        int len_s = s.length();
        
        int [] arr = new int[26];
        for(char ch : p.toCharArray()){
            arr[ch-'a']++;
        }
        
        int st=0;
        for(int ed=0; ed<len_s; ed++){
            
            arr[s.charAt(ed)-'a']--;
            
            if(ed-st+1<p.length()){
                continue;
            }
            
            if(ed-st+1>p.length()){
                arr[s.charAt(st)-'a']++;
                st++;
            }
            
            boolean hit=true;
            for(int a : arr){
                if(a!=0){
                    hit=false;
                    break;
                }
            }
            
            
            if(hit) 
                res.add(st);
        }
        
        return res;
        
    }
}