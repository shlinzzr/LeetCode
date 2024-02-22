// https://leetcode.com/problems/palindrome-pairs

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String, Integer> map = new HashMap<>(); //word, index
        TreeSet<Integer> set = new TreeSet<>();
        int len = words.length;
        for(int i=0; i<len;i++){
            map.put(words[i], i);
            set.add(words[i].length());
        }
        
        List<List<Integer>> res = new ArrayList<>();
        
        
        for(int i=0; i<len; i++){
            
            String w = words[i];
            int wLen = w.length();
            
            if(wLen==1){
                if(map.containsKey("")){
                    res.add(Arrays.asList(i, map.get("")));
                    res.add(Arrays.asList(map.get(""), i));
                }
                continue;
            }
            
            String reverse = new StringBuilder(w).reverse().toString();
            if(map.containsKey(reverse) && map.get(reverse)!=i){
                res.add(Arrays.asList(i, map.get(reverse)));
                // res.add(Arrays.asList(map.get(reverse), i));
            }
                        
            
            for(int k : set){
                
                if(k==wLen)
                    break;
            
                // find "sssll" prefix 
                // curr = sssll finding lls
                // rev = lls 'ss' check 'ss' is palindrome
                if(isPalindrome(reverse, k, wLen-1)){
                    String sub = reverse.substring(0, k);
                    if(map.containsKey(sub)){
                        res.add(Arrays.asList(map.get(sub), i));
                    }
                }
                
                
                // find "sssll" postfix
                // curr = sssll finding 'sss'
                // rev = ll'sss' checking 'll' is palindorme
                if(isPalindrome(reverse, 0, wLen-k-1)){
                    String sub = reverse.substring(wLen-k, wLen);
                    if(map.containsKey(sub)){
                        res.add(Arrays.asList(i, map.get(sub)));
                    }
                }
            }            
        }
                        
                        return res;
        
    }
                        
    private boolean isPalindrome(String s, int st, int ed){
        
        while(st<ed){
            if(s.charAt(st++)!=s.charAt(ed--)){
                return false;
            }
        }
        
        return true;
    }
                        
}