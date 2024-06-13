// https://leetcode.com/problems/first-unique-character-in-a-string

class Solution {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        Arrays.fill(arr, -2);
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(i==0 || arr[c-'a']==-2){
                arr[c-'a']=i;
                
            }else{
                arr[c-'a']=-1;
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i: arr){
            if(i!=-2)
                min = Math.min(i, min);
        }
        
        if(min==Integer.MAX_VALUE)
            min=-1;
        
        
        
        return min;
        
    }
}