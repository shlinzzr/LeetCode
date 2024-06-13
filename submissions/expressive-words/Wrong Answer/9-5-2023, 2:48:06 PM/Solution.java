// https://leetcode.com/problems/expressive-words

class Solution {
    public int expressiveWords(String s, String[] words) {
        
        int[] arr = new int[26];
        for(char ch : s.toCharArray()){
            arr[ch-'a']++;
        }

        int cnt =0 ;
        
        for(String w : words){
            
            int[] temp = new int[26];
            for(char ch : w.toCharArray()){
                temp[ch-'a']++;
            }
            
            boolean flag = true;
            for(int i=0; i<26; i++){
                
                int t = temp[i];
                
                if(t==0 && arr[i]==0)
                    continue;
                
                if(t>arr[i] || (t<arr[i] && arr[i]<3) || (arr[i]!=0 && t==0)){
                    flag=false;
                    break;
                }
            }
            
            if(flag)
                cnt++;
        }
        
        return cnt;
        
    }
}