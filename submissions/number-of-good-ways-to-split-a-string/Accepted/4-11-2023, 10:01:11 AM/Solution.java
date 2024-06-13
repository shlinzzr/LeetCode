// https://leetcode.com/problems/number-of-good-ways-to-split-a-string

class Solution {
    public int numSplits(String s) {
        int[] arr = new int[26];
        for(char ch : s.toCharArray()){
            arr[ch-'a']++;
        }
        
        int distinct=0;
        for(int a : arr){
            if(a!=0)
                distinct++;
        }
        

        int res=0;
        int curr=0;
        int[] arr2 = new int[26];
        for(char ch : s.toCharArray()){
            
            arr[ch-'a']--;
            if(arr[ch-'a']==0)
                distinct--;
            
            if(arr2[ch-'a']==0)
                curr++;
            arr2[ch-'a']++;
            
            
            if(distinct==curr)
                res++;
        }
        
        return res;
        
        
    }
}