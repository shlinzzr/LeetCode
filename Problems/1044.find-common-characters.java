// https://leetcode.com/problems/find-common-characters

class Solution {
    public List<String> commonChars(String[] words) {

        List<String> res = new ArrayList<>();
        int[] arr = new int[26];

       
        for(int i=0; i<words.length; i++){
            String w = words[i];

            if(i==0){
                for(char ch : w.toCharArray()){
                    arr[ch-'a']++;
                }
            }else{
                int[] temp = new int[26];
                for(char ch : w.toCharArray()){
                    temp[ch-'a']++;
                }

                for(int j=0; j<26;j++){
                    arr[j] = Math.min(arr[j], temp[j]);
                }
            }


            
        }

        for(int i=0; i<26; i++){
            int loop = arr[i];
            while(loop-->0){
                res.add( (char) (i+'a') + "");
            }
        }

        return res;
        
    }
}