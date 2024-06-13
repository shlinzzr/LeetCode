// https://leetcode.com/problems/satisfiability-of-equality-equations

class Solution {
    public boolean equationsPossible(String[] equations) {
        
        HashMap<Character, Set<Character>> eq = new HashMap<>();
        HashMap<Character, Set<Character>> ne = new HashMap<>();
        
        
        for(String s : equations){
            char varA = s.charAt(0);    
            char varB = s.charAt(3);
            
            if(s.charAt(1)=='='){
                
                addMap(varA, varB, eq);
            
            }else{
                addMap(varA, varB, ne);
            }
            
            HashSet<Character> setA = map.get(varA);
            setA.add(varB);
            for(String key : setA){
                if(key.)
            }
            
            
            
            
        }
        
        
        
        
       
    }
    
    private void addMap(Character varA, Character varB, HashMap<Character, Set<Character>> map){
        
        HashSet<Character> setA = new HashSet<>();
        if(map.containsKey(varA)){
            setA = map.get(varA);
        }
        setA.add(varB);
        map.put(varA, setA);

        HashSet<Character> setB = new HashSet<>();
        if(map.containsKey(varB)){
            setB = map.get(varB);
        }
        setB.add(varA);
        map.put(varB, setB);
    }
}