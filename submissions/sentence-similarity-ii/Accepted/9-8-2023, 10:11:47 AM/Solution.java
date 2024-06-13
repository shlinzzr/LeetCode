// https://leetcode.com/problems/sentence-similarity-ii

class Solution {
    public boolean areSentencesSimilarTwo(String[] a, String[] b, List<List<String>> pairs) {
        
        int len1 = a.length;
        int len2 = b.length;
        
        if(len1!=len2) return false;
        
        HashMap<String,String> map = new HashMap<>();
        
        
        //build parent
        for(List<String> p : pairs){
            String parent0 = find(map, p.get(0));
            String parent1 = find(map, p.get(1));
            
            if(!parent0.equals(parent1))
                map.put(parent0, parent1);
        }

        for(int i=0; i<a.length; i++){
            if(!a.equals(b) && !find(map, a[i]).equals(find(map, b[i])))
                return false;
        }
        return true;
        
        
    }
    
    
    private String find(HashMap<String, String> map, String s){
        if(!map.containsKey(s))    map.put(s,s);
        
        return s.equals(map.get(s)) ? s : find(map, map.get(s));
        
    }
}