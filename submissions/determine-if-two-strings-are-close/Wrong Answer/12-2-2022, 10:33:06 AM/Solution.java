// https://leetcode.com/problems/determine-if-two-strings-are-close

class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        
        for(char ch : word1.toCharArray()){
            arr1[ch-'a']++;
        }
        
        for(char ch : word2.toCharArray()){
            arr2[ch-'a']++;
        }
        
        
        String str1="";
        for(int a : arr1){
            if(a!=0){
                str1 += a;
            }
        }
        
        String str2="";
        for(int a : arr2){
            if(a!=0){
                str2 += a;
            }
        }
            
    
        char[] carr1 = str1.toCharArray();
        Arrays.sort(carr1);
            
        char[] carr2 = str2.toCharArray();
        Arrays.sort(carr2);
            
        for(int i=0; i<carr1.length; i++){
            if(carr1[i]!=carr2[i])
                return false;
        }
            
            
        return true;
        
        
    }
}