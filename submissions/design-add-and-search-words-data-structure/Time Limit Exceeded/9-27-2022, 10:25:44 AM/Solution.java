// https://leetcode.com/problems/design-add-and-search-words-data-structure

class WordDictionary {

    HashSet<String> set ;
    public WordDictionary() {
        set = new HashSet<>();
    }
    
    public void addWord(String word) {
        set.add(word);
    }
    
    public boolean search(String word) {
        
        for(String s : set){
            if(isMatch(s, word))
                return true;
        }        
        return false;
    }
    
    
    private boolean isMatch(String word, String pattern){
        int i=0, j=0;
        while(i<word.length()){
            
            if(j<pattern.length() &&( word.charAt(i)==pattern.charAt(j) || pattern.charAt(j)=='.')){
                i++;
                j++;
            }else{
                return false;
            }
        }
        
        if(j<pattern.length())
            return false;
               
        return true;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */