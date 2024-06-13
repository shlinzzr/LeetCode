// https://leetcode.com/problems/smallest-k-length-subsequence-with-occurrences-of-a-letter

class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        TreeMap<Character, Integer> map = new TreeMap<>();

        // leet, len=4, k=3
        
        for(int i=0; i<=s.length()-k){
            map.put(s.charAt(i), i);
            
        }

        HashMap<Character, Integer> cntMap = new HashMap<>();
        int idx = s.length()-1;
        for(; idx>=s.length()-k+1; idx--){
            cntMap.put(s.charAt(idx), cntMap.getOrDefault(s.charAt(idx),0)+1);
        }

        while(cntMap.get(letter)<repetition){
            char ch = s.charAt(idx);
            cntMap.put(ch, cntMap.getOrDefault(ch,0)+1);
            idx++;
            map.p
            
        }

        
    }
}