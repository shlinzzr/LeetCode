// https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character

class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        
        int len = queries.length;
        
        int[] res = new int[len];
        
        for(int i=0; i<len; i++){
            String q = queries[i];
            int base = f(q);
            
            int cnt= 0 ;
            for(String w : words){
                if(f(w)>base){
                    cnt++;
                }
            }
            
            res[i] = cnt;
        }
        
        return res;
        
        
    }
    
    
    private int f(String s ){
        int[] arr = new int[26];
        for(char ch : s.toCharArray()){
            arr[ch-'a']++;
        }
        
        for(int a : arr){
            if(a!=0)
                return a;
        }
        
        return 0;
        
    }
}