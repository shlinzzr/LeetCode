// https://leetcode.com/problems/find-all-anagrams-in-a-string

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] arr = new int[26];
        for(char ch : p.toCharArray()){
            arr[ch-'a']++;
        }

        int st=0;
        int wordLen = p.length();
        int[] cur = new int[26];
        for(int ed=0; ed<s.length(); ed++){
            char ch = s.charAt(ed);
            cur[ch-'a']++;

            if(ed+1<wordLen)
                continue;

            if(isAna(arr, cur))
                res.add(st);
            
            char chst = s.charAt(st++);
            cur[chst-'a']--;
        }

        return res;

    }


    private boolean isAna(int[] a, int[] b){
        for(int i=0; i<26; i++){
            if(a[i]!=b[i])
                return false;
        }
        return true;
    }
}