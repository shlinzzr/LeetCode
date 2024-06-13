// https://leetcode.com/problems/destination-city

class Solution {
    public String destCity(List<List<String>> paths) {
        HashSet<String> seen = new HashSet<>();
        HashSet<String > out = new HashSet<>();

        for(List<String> p : paths){
            seen.add(p.get(1));
            out.add(p.get(0));
        }

        for(String o : out){
            seen.remove(o);
        }

        return new ArrayList<>(seen).get(0);
    }

}