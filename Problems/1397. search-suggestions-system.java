// https://leetcode.com/problems/search-suggestions-system

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        
        Arrays.sort(products);
        
        List<List<String>> res = new ArrayList<>();
        
        String curr = "";
        
        for(int i=0; i<searchWord.length(); i++){
            
            char c = searchWord.charAt(i);
            curr += c;
            
            
            List<String> list = new ArrayList<>();
            
            for(String prod : products){
                
                if(prod.startsWith(curr)){
                    list.add(prod);
                }
                
                if(list.size()==3)
                    break;
            }
            
           
            // list  = list.subList(0, list.size()>3 ? 3 : list.size());
            
            
            res.add(list);
            
        }
        
        return res;
        
    }
}