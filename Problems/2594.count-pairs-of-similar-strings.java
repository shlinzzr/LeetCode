// https://leetcode.com/problems/count-pairs-of-similar-strings

class Solution {
    public int similarPairs(String[] words) {
        
        
        int len = words.length;
        int cnt=0;
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                
                String s1 = helper(words[i]);
                String s2 = helper(words[j]);
                
                if(s1.equals(s2)){
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
    
    private String helper(String w){
        
        int[] arr = new int[26];
        for(char ch : w.toCharArray()){
            arr[ch-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++){
            if(arr[i]>0)
                sb.append((char)(i+'a'));
        }
        
        return sb.toString();
        
        
    }
            
        
        
        
//         HashMap<String, Integer> map = new HashMap();
        
//         for(String w : words){
            
//             int[] arr = new int[26];
            
//             for(char ch : w.toCharArray()){
//                 arr[ch-'a']++;
//             }
//             StringBuilder sb = new StringBuilder();
//             for(int i=0; i<26; i++){
//                 if(arr[i]>0){
//                     sb.append((char)(i+'a'));
//                 }
//             }            
            
//             map.put(sb.toString(), map.getOrDefault(sb.toString(), 0)+1);
//         }
        
//         int cnt =0;
//         for(Map.Entry<String, Integer> en : map.entrySet()){
//             System.out.println(en.getKey() + " " + en.getValue());
            
//             if(en.getValue()>=2)
//                 cnt+= en.getValue();
//         }
        
        
//         return cnt;
}