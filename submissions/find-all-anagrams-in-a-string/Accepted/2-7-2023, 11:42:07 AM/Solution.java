// https://leetcode.com/problems/find-all-anagrams-in-a-string

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] arr = new int[26];
        for(char ch : p.toCharArray()){
            arr[ch-'a']++;
        }
        
        int len = s.length();
        int cnt = 0;
        int st=0;
        for(int ed=0; ed<len; ed++){
            
            arr[s.charAt(ed)-'a']--;
            if((ed-st+1)==p.length()){
                
                boolean find=true;
                for(int a: arr){
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
}