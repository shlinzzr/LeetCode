// https://leetcode.com/problems/total-appeal-of-a-string

class Solution {
    public long appealSum(String s) {
//         long res = 0L;
//         int len = s.length();
//         for(int wordLen=1; wordLen<=len; wordLen++){
            
//             HashMap<String, Integer> map = new HashMap<>();
            
//             for(int st = 0; st+wordLen<=len; st++){
                
//                 String sub = s.substring(st, st+wordLen);
                
//                 int[] arr = new int[26];
//                 for(int i=0; i<sub.length(); i++){
//                     arr[sub.charAt(i)-'a']++;
//                 }
//                 int dis=0;
//                 for(int a : arr){
//                     if(a==1)
//                         dis++;
//                 }
//                 res+=dis;
//             }
//         }
        
        int last[] = new int[26];
        long res = 0;
        for (int i = 0; i < s.length(); ++i) {
            last[s.charAt(i) - 'a'] = i + 1;
            for (int j: last)
                res += j;
        }
        
        return res;
    }
}