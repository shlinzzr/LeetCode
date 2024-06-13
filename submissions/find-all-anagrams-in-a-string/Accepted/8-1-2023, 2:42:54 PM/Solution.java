// https://leetcode.com/problems/find-all-anagrams-in-a-string

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        
        int[] arr = new int[26];
        for(char ch : p.toCharArray()){
            arr[ch-'a']++;
        }
        
        int[] cur = new int[26];
        int st=0;
        
        int wordLen = p.length();
        
        for(int ed=0; ed<s.length(); ed++){
            
            char ch = s.charAt(ed);
            cur[ch-'a']++;
            
            if(ed<wordLen-1)
                continue;
            
            
            // print(arr);
            
            boolean flag = isAna(arr, cur);
            // System.out.println(st + " " + flag + " ");
            if(flag)
                res.add(st);
                
            
            ch = s.charAt(st++);
            cur[ch-'a']--;
        }
        
        return res;
        
        
    }
    
    private void print(int[] a){
        
        for(int aa: a){
            System.out.print(aa + ", ");
        }
        System.out.println();
    }
    
    private boolean isAna(int[] a, int[] b){
        
        for(int i=0; i<26;i++){
            if(a[i]!=b[i])
                return false;
        }       
        return true;
        
    }
}