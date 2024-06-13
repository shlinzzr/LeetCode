// https://leetcode.com/problems/letter-tile-possibilities

class Solution {
    int cnt=0;
    public int numTilePossibilities(String tiles) {
        
        Set<String> set =new HashSet<>();
        boolean[] barr = new boolean[tiles.length()];
        
        helper(tiles, "", 0, set, barr);
        
        return set.size();
    }
    
    
    private void helper(String tiles, String curr, int step, Set<String> set,  boolean[] barr){
        
        if(!curr.isEmpty())
            set.add(curr);
        
        if(step==tiles.length())
            return;
        
        for(int i=0; i<tiles.length(); i++){
            char c = tiles.charAt(i);
            if(barr[i]==false){
                barr[i]=true;
                helper(tiles, curr + c, step+1, set, barr);    
                barr[i]=false;
            }
            
        }
    }
}