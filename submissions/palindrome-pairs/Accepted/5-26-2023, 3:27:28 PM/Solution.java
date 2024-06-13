// https://leetcode.com/problems/palindrome-pairs

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String, Integer> wordMap = new HashMap<>(); // word, index
        Set<Integer> set = new TreeSet<>();
        int n = words.length;
        for(int i=0;i<n;i++){
            wordMap.put(words[i],i);
            set.add(words[i].length());
        }
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            int wLen = words[i].length();
            
            if(wLen ==1){ //case 0: wLen==1 and contains empty string
                if(wordMap.containsKey("")){
                    res.add(Arrays.asList(i, wordMap.get("")));
                    res.add(Arrays.asList(wordMap.get(""), i));
                }
                continue;
            }
            
            // case 1: got reverse prefect match
            String reverse= new StringBuilder(words[i]).reverse().toString();
            if(wordMap.containsKey(reverse) && wordMap.get(reverse) != i)
                res.add(Arrays.asList(i,wordMap.get(reverse)));
            

            for(Integer k : set){
                // means next strings will be larger than current one
                //hence no prefix suffix would be possible
                if(k == wLen) break;
                
                //find prefix      
                //current string = sssll  ==> when k==3, need to find 'lls' & and check 'ss' isPalindrome;
                //reverse string = lls'ss'
                //we are checking if 'ss' is an palindrome
                
                if(isPalindrome(reverse, k, wLen-1)){
                    String sub = reverse.substring(0, k); // lls 
                    //there should be an string: sss in map
                    if(wordMap.containsKey(sub)){
                        res.add(Arrays.asList(wordMap.get(sub), i));
                    }
                    
                    //  if("lls".equals(words[i])){
                    //     System.out.println(reverse.substring(wLen-k));
                    //     System.out.println(wordMap.containsKey(sub));
                    // }
                }
                
                //find suffix  e.g k==3  
                //current string= sssll  // e.g. finding 'sss' and check 'll' isPalindrome
                //reverse string= ll'sss'
                //'ll' should be an palindrome
                if(isPalindrome(reverse,0,wLen-1-k)){ // isPalindrome("sll".sub(0,1))==true
                    String sub = reverse.substring(wLen-k);
                    if(wordMap.containsKey(sub)){
                        res.add(Arrays.asList(i,wordMap.get(sub)));
                    }
                }
            }
        }
        return res;
    }
    
    private boolean isPalindrome(String s, int left, int right){
        while(left<right)
            if(s.charAt(left++)!=s.charAt(right--))
                return false;
        return true;
    }
}