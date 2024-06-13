// https://leetcode.com/problems/optimal-partition-of-string

class Solution {
    public int partitionString(String s) {
        int cnt =0;
        int[] arr = new int[26];
        boolean isNew = true;
        
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(arr[ch-'a']==0){
                arr[ch-'a']++;
                if(isNew){
                    cnt++;
                  isNew =false;  
                } 
            }else{
                cnt++;
                Arrays.fill(arr, 0);
                isNew =true;
            }
        }
        
        return cnt;
        
    }
}