// https://leetcode.com/problems/replace-question-marks-in-string-to-minimize-its-value

class Solution {
    public String minimizeStringValue(String s) {
        
        char[] arr = s.toCharArray();
        int len = arr.length;
        
        // a???a???
        // abbca
        // abcc
        
        int[] dict = new int[26];
        for(int i=0; i<arr.length; i++){
            char ch = arr[i];
            if(ch!='?') dict[ch-'a']++;
        }
        
        for(int i=arr.length-1; i>=0; i--){
            
            if(arr[i]=='?'){
                for(int j=25; j>=0; j--){
                    if(dict[j]==0){
                        dict[j]++;
                        arr[i] = (char) (j+'a');
                        break;
                    }
                }
                
                if(arr[i]=='?'){
                    arr[i] = 'a';
                }
            }
            
        }
        
        return new String(arr);
        
    }
}