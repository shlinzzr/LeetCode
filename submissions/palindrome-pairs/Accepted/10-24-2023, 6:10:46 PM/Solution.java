// https://leetcode.com/problems/palindrome-pairs

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String, Integer> map = new HashMap<>(); //word, index
        TreeSet<Integer> set = new TreeSet<>();// length
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
            
            String reverse = new StringBuilder(w).reverse().toString(); //  case 0 : abcd, dcba
            if(map.containsKey(reverse) && map.get(reverse)!=i){
                res.add(Arrays.asList(i, map.get(reverse)));
            }
            
            for(int k : set){ // from short to long
                
                if(k==wLen) // reverse case0 is already done, break
                    break;
            
                
                // case 1:
                //  w = "sssll", using reverse string "llsss" to find palindrome, 
                //     that is : lls  ss
                //               ^^^  ^^
                // map.contains(0,k)  isPal(k, wLen-1)
                // then we find "lls" 
                String sub = reverse.substring(0, k);
                if(map.containsKey(sub) && isPalindrome(reverse, k, wLen-1)){
                    res.add(Arrays.asList(map.get(sub), i));
                }
                

                
                // case 2 : if we append one more string : "sss" to words
                // now: w = "sssll",  using reverse/contains "llsss" to find palindrome, 
                //     that is : ll sss
                //               ^^ ^^^
                //  isPal(0, wLen-k-1) map.contains(wLen-k, wLen)
                // then we find "sss"
                sub = reverse.substring(wLen-k, wLen);
                if(isPalindrome(reverse, 0, wLen-k-1) && map.containsKey(sub)){
                    res.add(Arrays.asList(i, map.get(sub)));
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