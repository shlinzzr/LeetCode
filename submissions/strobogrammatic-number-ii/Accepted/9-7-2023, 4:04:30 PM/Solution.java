// https://leetcode.com/problems/strobogrammatic-number-ii

class Solution {
    HashMap<Integer, Integer> map  = new HashMap<>();
        
    
    List<Integer> list = new ArrayList<>(Arrays.asList(0,1,8,6,9));
    
    public List<String> findStrobogrammatic(int n) {
        map.put(0,0);
        map.put(1,1);
        map.put(8,8);
        map.put(6,9);
        map.put(9,6);
        
        List<String> res = new ArrayList<>();
        
        bfs(res, new StringBuilder(), n);
        
        return res;
    }
    
    private void bfs(List<String> res, StringBuilder ssb, int n){
        
        if(n%2==0 && ssb.length()==n/2){
            StringBuilder sb = new StringBuilder();
            for(char ch : ssb.toString().toCharArray()){
                sb.insert(0, map.get(ch-'0'));
            }
            res.add( ssb.toString()+sb.toString());
            return;
        }
        
        if(n%2==1 && ssb.length()==(n-1)/2){
            StringBuilder sb = new StringBuilder();
            for(char ch : ssb.toString().toCharArray()){
                sb.insert(0, map.get(ch-'0'));
            }
            res.add(ssb.toString() + "0" + sb.toString());
            res.add(ssb.toString() + "1" + sb.toString());
            res.add(ssb.toString() + "8" + sb.toString());
            return;
        }
        
        
        for(int i : list){
            if(ssb.length()==0 && i==0)
                continue;
            
            ssb.append(""+i);
            bfs(res, ssb, n);
            ssb.deleteCharAt(ssb.length()-1);
        }
        
    }
    
}