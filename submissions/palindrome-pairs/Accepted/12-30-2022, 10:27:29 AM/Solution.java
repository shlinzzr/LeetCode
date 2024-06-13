// https://leetcode.com/problems/palindrome-pairs

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String,Integer> wordMap = new HashMap<>();
        Set<Integer> set = new TreeSet<>();
        int n = words.length;
        
        for(int i=0;i<n;i++){
            wordMap.put(words[i],i);
            set.add(words[i].length());
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            int length = words[i].length();
            
            if(length ==1){
                if(wordMap.containsKey("")){
                    ans.add(Arrays.asList(i, wordMap.get("")));
                    ans.add(Arrays.asList(wordMap.get(""), i));
                }
                continue;
            }
            String reverse= new StringBuilder(words[i]).reverse().toString();
            if(wordMap.containsKey(reverse) && wordMap.get(reverse) != i)
                ans.add(Arrays.asList(i,wordMap.get(reverse)));
            

            for(Integer k:set){
                // means next strings will be larger than current one
                //hence no prefix suffix would be possible
                if(k == length) break;
                
                //adding prefix
                //string:  llsss
                //reverse: sssll
                //we are checking if ll is an palindrome
                if(isPalindrome(reverse,k,length-1)){
                    String s1 =  reverse.substring(0,k);
                    //there should be an string: sss in map
                    if(wordMap.containsKey(s1)){
                        ans.add(Arrays.asList(wordMap.get(s1),i));
                    }
                }

                //adding suffix
                //string: sssll
                //reverse: llsss
                //ll should be an palindrome
                //remove sss, string of length k from end
                if(isPalindrome(reverse,0,length-1-k)){
                    //get sss: i.e. last k elements of reversed string
                    String s1 = reverse.substring(length-k);
                    if(wordMap.containsKey(s1)){
                        ans.add(Arrays.asList(i,wordMap.get(s1)));
                    }
                }
            }
        }
        return ans;
    }
    
    private boolean isPalindrome(String s, int left, int right){
        while(left<right)
            if(s.charAt(left++)!=s.charAt(right--))
                return false;
        return true;
    }
}