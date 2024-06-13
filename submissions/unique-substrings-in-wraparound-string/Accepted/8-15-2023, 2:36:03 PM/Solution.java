// https://leetcode.com/problems/unique-substrings-in-wraparound-string

class Solution {
    public int findSubstringInWraproundString(String s) {
        
//         for (char c : p.toCharArray()) {
//           res[c-'a'] = 1;
//         }

//         int l = 1;
//         for (int j = 1; j < p.length(); j++) {
//           int k = p.charAt(j) - 'a';
//           l = (k == (p.charAt(j-1)-'a' + 1) % 26) ? l + 1 : 1;
//           res[k] = Math.max(res[k], l);
//         }
//         return Arrays.stream(res).sum();
        
        
        // res[k] is the maximum length of qualified substring in p that ends with character 'a' + k
        int[] res = new int[26];
        for (char ch : s.toCharArray()) {
            res[ch-'a'] = 1;
        }

        int i = 1;
        for (int j = 1; j < s.length(); j++) {
          int k = s.charAt(j) - 'a';
          i = (k == (s.charAt(j-1)-'a' + 1) % 26) ? i+1 : 1;
          res[k] = Math.max(res[k], i);
        }
        
        
        
        return Arrays.stream(res).sum();
        
        
        // wa
//         int[] arr = new int[26];
        
//         LinkedHashSet<String> set = new LinkedHashSet<>();
//         String curr = "";
        
        
//         for(char ch='a'; ch<='z'; ch++){
//             for(int i=0; i<26;i++){
//                 curr += (char)((ch-'a'+i)%26+'a');
//                 set.add(curr);
//             }
//             curr = "";
//         }
        
        
//         int res =0;
        
//         Set<String> seen = new HashSet<>();
        
//         for(int i=0; i<s.length(); i++){
//             char ch = s.charAt(i);
//             arr[ch-'a']++;
            
            
//             for(int j=i+1; j<=s.length(); j++){
//                 String sub = s.substring(i, j);
//                 if(set.contains(sub) && !seen.contains(sub)){
//                     res++;
//                     seen.add(sub);
//                 }
                    
//             }
            
//         }
//         return res;
        
    }
}