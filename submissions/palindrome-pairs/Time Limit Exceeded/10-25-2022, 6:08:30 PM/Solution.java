// https://leetcode.com/problems/palindrome-pairs

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++){        
            map.put(words[i], i);
        }
        
        
        for(int i=0; i<words.length; i++){
            String w = words[i];
            
            for(int j=0; j<=w.length(); j++){
                
                String str1 = w.substring(0, j);
                String str2 = w.substring(j);
                
                
                // XXXX YYY  XXXX
                //      str1 str2
                //     |->  w  <-|  w 在後面
                
                if(isPalindrome(str1)){ // 
                    String rev = getReverse(str2);    
                    if(map.containsKey(rev)  && map.get(rev) != i ){
                        List<Integer> list = new ArrayList<>();
                        
                        list.add(map.get(rev));
                        list.add(i);
                        
                        res.add(list);
                    }
                }
                
                // XXXX YYY  XXXX
                // str1 str2
                //|->  w  <-|  w 在前面
                if(isPalindrome(str2)){
                    String rev = getReverse(str1);    
                    if(map.containsKey(rev) && map.get(rev) != i && str2.length()!=0){
                        List<Integer> list = new ArrayList<>();
                        
                        list.add(i);
                        list.add(map.get(rev));
                        res.add(list);
                    }
                }
            }
        }
        
        return res;
    }
    
    private String getReverse(String w){
        StringBuilder sb = new StringBuilder(w);
        return sb.reverse().toString();
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left++) !=  str.charAt(right--)) return false;
        }
        return true;
    }
    
    
//     private boolean isPalindrome(String ab){
//         for(int i=0; i<ab.length()/2; i++){
//             if(ab.charAt(i)!=ab.charAt(ab.length()-1-i))
//                 return false;
//         }
        
//         return true;
        
//     }
}