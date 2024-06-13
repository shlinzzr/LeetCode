// https://leetcode.com/problems/unique-substrings-in-wraparound-string

class Solution {
    public int findSubstringInWraproundString(String s) {
        int[] arr = new int[26];
        
        LinkedHashSet<String> set = new LinkedHashSet<>();
        String curr = "";
        
        
        for(char ch='a'; ch<='z'; ch++){
            for(int i=0; i<26;i++){
                curr += (char)((ch-'a'+i)%26+'a');
                set.add(curr);
            }
            curr = "";
        }
        
        
        int res =0;
        
        Set<String> seen = new HashSet<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            arr[ch-'a']++;
            
            
            for(int j=i+1; j<=s.length(); j++){
                String sub = s.substring(i, j);
                if(set.contains(sub) && !seen.contains(sub)){
                    res++;
                    seen.add(sub);
                }
                    
            }
            
        }
        
        
        // for(int i=1; i<26; i++){
        //     if(arr[i]!=0)
        //         res++;
        // }
        
        return res;
        
    }
}