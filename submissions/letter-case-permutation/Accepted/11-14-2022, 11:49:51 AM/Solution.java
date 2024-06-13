// https://leetcode.com/problems/letter-case-permutation

class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        helper(res, s, 0);
        
        return res;
        
    }
    
    private void helper(List<String> res, String s, int st){
        
        res.add(s);
        
        char[] arr = s.toCharArray();
        
        for(int i=st; i<s.length(); i++){
            
            if((arr[i]-'a'>=0 && arr[i]-'a'<26) || (arr[i]-'A'>=0 && arr[i]-'A'<26)){
                
                if(arr[i]-'a'>=0 && arr[i]-'a'<26){
                    
                    arr[i] = (char) (arr[i]-'a'+'A');
                    helper(res, new String(arr), i+1);
                    arr[i] =  (char) (arr[i]-'A'+'a');
                    
                }else{
                    arr[i] =  (char) (arr[i]-'A'+'a');
                    helper(res, new String(arr), i+1);
                    arr[i] =  (char) (arr[i]-'a'+'A');
                    
                }
            }
        }
        
        
    }
}