// https://leetcode.com/problems/count-vowel-strings-in-ranges

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        
        int[] res = new int[queries.length];
        
        List<Character> list = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        for(int j=0; j<queries.length; j++){
            int[] q = queries[j];
            int cnt=0;
            for(int i=q[0]; i<=q[1]; i++){
                String w = words[i];
                
                if(list.contains(w.charAt(0)) && list.contains(w.charAt(w.length()-1)))
                    cnt++;
            }
            
            res[j]=cnt;
            
        
        }
        
        return res;
    }
}