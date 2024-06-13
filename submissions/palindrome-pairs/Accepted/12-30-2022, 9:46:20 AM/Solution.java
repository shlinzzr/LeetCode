// https://leetcode.com/problems/palindrome-pairs

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        
        // https://www.youtube.com/watch?v=L7MmngL-iaM TLE
        
        List<List<Integer>> res = new ArrayList<>();
        
        int len = words.length;
        
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<len ; i++){
            map.put(words[i], i);
            
        }
        
        Arrays.sort(words, (a,b) -> a.length()-b.length());
        
        for(int i=0; i<len; i++){
            
            String s = words[i];
            
            for(int k=0; k<=s.length(); k++){
                
                String s1 = s.substring(0, k);
                String s2 = s.substring(k);
                
                if(isPal(s1)){
                    StringBuilder sb = new StringBuilder(s2);
                    String t = sb.reverse().toString();
                    if(!s.equals(t) && set.contains(t)){
                        res.add(Arrays.asList(map.get(t), map.get(s)));
                    }
                }
                
                if(isPal(s2)){
                    StringBuilder sb = new StringBuilder(s1);
                    String t = sb.reverse().toString();
                    if(!s.equals(t) && set.contains(t)){
                        res.add(Arrays.asList(map.get(s), map.get(t)));
                    }
                }
            }
            
            set.add(words[i]);
        }        
        
        return res;
    }
    
    
    private boolean isPal(String s){
        
        int len = s.length();
        for(int i=0; i<len/2; i++){
            
            if(s.charAt(i)!=s.charAt(len-i-1)){
                return false;
            }
        }
        return true;
    }
}