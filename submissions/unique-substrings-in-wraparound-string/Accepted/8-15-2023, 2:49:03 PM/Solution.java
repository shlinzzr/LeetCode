// https://leetcode.com/problems/unique-substrings-in-wraparound-string

class Solution {
    public int findSubstringInWraproundString(String p) {
        
        // count[i] is the maximum unique substring end with ith letter.
        // 0 - 'a', 1 - 'b', ..., 25 - 'z'.
        int[] count = new int[26];
        
        // store longest contiguous substring ends at current position.
        int maxLengthCur = 0; 

        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || (p.charAt(i - 1) - p.charAt(i) == 25))) {
                maxLengthCur++;
            }
            else {
                maxLengthCur = 1;
            }
            
            int index = p.charAt(i) - 'a';
            count[index] = Math.max(count[index], maxLengthCur);
        }
        
        // Sum to get result
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += count[i];
        }
        return sum;
        
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