// https://leetcode.com/problems/count-vowel-strings-in-ranges

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        
        int len = words.length;
        
        boolean[] bool = new boolean[len];
        for(int i=0; i<len; i++){
            if( set.contains(words[i].charAt(0))  && set.contains(words[i].charAt(words[i].length()-1) ) )
                bool[i]=true;
        }
        
        int[] presum = new int[len];
        for(int i=0; i<len; i++){
            if(i==0){
                presum[i] =(bool[i] ? 1:0);
            }else{
                presum[i] = presum[i-1] + (bool[i] ? 1:0);
            }
        }
        
        int[] res = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            
            int[] q = queries[i];
            
            int st=q[0];
            int ed=q[1];
            
            res[i] = presum[ed]-(st==0? 0 : presum[st-1]);
        }
        
        return res;
        
        
        
        
    }
}