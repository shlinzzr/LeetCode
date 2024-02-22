// https://leetcode.com/problems/optimal-partition-of-string

class Solution {
    public int partitionString(String s) {
        int cnt =1;
        int[] arr = new int[26];
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(arr[ch-'a']!=0){
                cnt++;
                Arrays.fill(arr, 0);
            }
            
            arr[ch-'a']++;
            
            
        }
        
        return cnt;
        
    }
}